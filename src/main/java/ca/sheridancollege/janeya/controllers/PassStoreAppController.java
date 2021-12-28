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
import ca.sheridancollege.janeya.tools.UserIDCreation;

@Controller
public class PassStoreAppController {

	@Autowired
	private DatabaseAccess da;

	private UserIDCreation uidc;

	@GetMapping("/index")
	public String index(Model model){
		model.addAttribute("user", new User());
		return "/index";
	}
	@PostMapping("/index")
	public String indexSubmit(Model model, @ModelAttribute User user) {
		User usr = da.checkCredentials(user);
		if(usr != null)
			return "/viewList";
		else
			return "/badLogin";
	}

	@GetMapping("/register")
	public String register(){
		return "/register";
	}
	@PostMapping("/register")
	public String registerSubmit(){
		return null;
	}
}