package ca.sheridancollege.janeya.controllers;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ca.sheridancollege.janeya.beans.Password;
import ca.sheridancollege.janeya.beans.User;
import ca.sheridancollege.janeya.dao.DatabaseAccess;
import ca.sheridancollege.janeya.tools.UserIDCreation;

@Controller
public class PassStoreAppController {

	@Autowired
	private DatabaseAccess da;
	private UserIDCreation uidc;

	//initial login page
	@GetMapping("/index")
	public String index(Model model, @RequestParam(name = "username") String username,
	@RequestParam(name = "password") String password){
		User user = new User();
		user.setUser(username);
		user.setPass(password);
		model.addAttribute("user", user);
		return "/index";
	}
	@PostMapping("/index")
	public String indexSubmit(Model model, @ModelAttribute User user, HttpSession session){
		User result = da.checkCredentials(user.getUser(), user.getPass());
		if(result != null){
			session.setAttribute("userId", result.getId());
			return "/viewPasswords";
		}
		else
			return "/badLogin";
	}

	//bad login
	@GetMapping("badLogin")
	public String badLogin(){
		return "/badLogin";
	}

	//register user page
	@GetMapping("/register")
	public String register(Model model, @RequestParam(name = "username") String username,
		@RequestParam(name = "password") String password){
		User user = new User();
		user.setId(uidc.createId(16));
		user.setUser(username);
		user.setPass(password);
		model.addAttribute("user", user);
		return "/register";
	}
	@PostMapping("/register")
	public String registerSubmit(Model model, @ModelAttribute User user){
		long rowsAffected = da.registerUser(user);
		if(rowsAffected >= 1){
			return "/confirmRegister";
		}
		else{
			return "/denyRegister";
		}
	}

	//view passwords page
	@PostMapping("/viewPasswords")
	public String viewPasswords(Model model, HttpSession session){
		String userId = (String) session.getAttribute("userid");
		List<Password> passwordList = da.selectPasswords(userId);
		model.addAttribute("passwordList", passwordList);
		return "/viewPasswords";
	}

	@GetMapping("/editPassword/{website}")
	public String editPassword(Model model, @PathVariable("website")String website){
		//Password password = da.selectAPassword(website);
		//model.addAttribute("password", password);
		return "/editPassword";
	}
	@PostMapping("/editPassword")
	public String editPasswordSubmit(Model model, @ModelAttribute Password password){
		//long rowsAffected = da.updatePassword(password);
		//if(rowsAffected >= 1)
			//return "/editConfirm";
		//else
			return "/editDeny";
	}
}