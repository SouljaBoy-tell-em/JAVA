package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/submit")
public class SubmitController {

	@GetMapping
	public String Submit(Model model) {
		
//		model.addAttribute("name", new Name());
		return "submit_form";
	}
	
	@ModelAttribute("name")
	public Name name() {
		return new Name();
	}
	
	@PostMapping
	public String send(@ModelAttribute Name name, Model model) {
		
		model.addAttribute("name", name);
		return "getform";
	}
}


