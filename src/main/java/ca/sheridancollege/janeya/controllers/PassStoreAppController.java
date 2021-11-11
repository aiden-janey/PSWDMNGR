package ca.sheridancollege.janeya.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ca.sheridancollege.janeya.beans.Password;

import ca.sheridancollege.janeya.dao.DatabaseAccess;

@Controller
public class PassStoreAppController {
	
	private DatabaseAccess da;

	@GetMapping("/index")
	public String index(Model model) {
		model.addAttribute("password", new Password());
		return "/index";
	}
	
	@PostMapping("/index")
	public String indexSubmit(Model model, 
			@ModelAttribute Password password) {
		long numOfRows = da.checkCredentials(password);
		return "/homepage";
	}
}
