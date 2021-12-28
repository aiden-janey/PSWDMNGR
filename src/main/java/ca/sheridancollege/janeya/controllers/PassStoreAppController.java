package ca.sheridancollege.janeya.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ca.sheridancollege.janeya.beans.Password;
import ca.sheridancollege.janeya.beans.User;
import ca.sheridancollege.janeya.dao.DatabaseAccess;

@Controller
public class PassStoreAppController {
	@Autowired
	private DatabaseAccess da;
	
	@GetMapping("/index")
	public String indexSubmit(){
		return "/index";
	}
	
	@GetMapping("/masterLogin")
	public String masterLogin(Model model) {
		model.addAttribute("user", new User());
		return "/masterLogin";
	}
	@PostMapping("/masterLogin")
	public String indexSubmit(Model model, @ModelAttribute User user) {
		User usr = da.checkCredentials(user);
		if(usr != null)
			return "/viewList";
		else
			return "/badLogin";
	}
	
	@PostMapping("{userid}/viewList")
	public String viewList(Model model) {
		List<Password> list = da.selectPasswords();
		model.addAttribute("list", list);
		return "/viewList";
	}
}