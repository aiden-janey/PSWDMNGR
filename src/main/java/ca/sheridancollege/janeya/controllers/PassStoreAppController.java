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
import org.springframework.web.bind.annotation.RequestMapping;
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

	// index page explaining the project
	@GetMapping("/index")
	public String index() {
		return "/index";
	}

	@PostMapping("/index")
	public String logInSubmit(Model model, @RequestParam(name = "username") String username,
			@RequestParam(name = "password") String password, HttpSession session) {
		List<User> result = da.checkCredentials(username, password);
		if (result.size() == 1) {
			User user = result.get(0);
			session.setAttribute("currentUser", user.getId());
			return "/viewPasswords";
		} else {
			return "/badLogin";
		}
	}

	// register user page
	@GetMapping("/register")
	public String register() {
		return "/register";
	}

	@PostMapping("/register")
	public String registerSubmit(Model model, @RequestParam(name = "username") String username,
			@RequestParam(name = "password") String password) {
		User user = new User();
		user.setId(uidc.createId(16));
		user.setUser(username);
		user.setPass(password);
		long rowsAffected = da.registerUser(user);
		if (rowsAffected >= 1)
			return "/index";
		else
			return "/badLogin";
	}

	// view passwords page
	@RequestMapping("/viewPasswords")
	public String viewPasswords(Model model, HttpSession session) {
		User user = (User) session.getAttribute("currentUser");
		List<Password> passwordList = da.selectPasswords("user.getId()");
		model.addAttribute("passwordList", passwordList);
		return "/viewPasswords";
	}

	@GetMapping("/editPassword/{website}")
	public String editPassword(Model model, @PathVariable("website") String website) {
		// Password password = da.selectAPassword(website);
		// model.addAttribute("password", password);
		return "/editPassword";
	}

	@PostMapping("/editPassword")
	public String editPasswordSubmit(Model model, @ModelAttribute Password password) {
		// long rowsAffected = da.updatePassword(password);
		// if(rowsAffected >= 1)
		// return "/editConfirm";
		// else
		return "/editDeny";
	}
}