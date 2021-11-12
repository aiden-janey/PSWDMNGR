package ca.sheridancollege.janeya.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ca.sheridancollege.janeya.beans.MasterPassword;
import ca.sheridancollege.janeya.dao.DatabaseAccess;

@Controller
public class PassStoreAppController {
	@Autowired
	private DatabaseAccess da;

	@GetMapping("/index")
	public String index() {
		return "/index";
	}
	
	@GetMapping("/masterLogin")
	public String masterLogin(Model model) {
		model.addAttribute("masterpassword", new MasterPassword());
		return "/masterLogin";
	}
	@PostMapping("/masterLogin")
	public String indexSubmit(Model model, @ModelAttribute MasterPassword pswd) {
		String verify = "/badLogin";
		List<MasterPassword> list = da.checkCredentials(pswd);
		if(list.size() > 1)
			verify = "/viewList";
		return verify;
	}
	
	@PostMapping("/viewList")
	public String viewList() {
		
		return "/viewList";
	}
}