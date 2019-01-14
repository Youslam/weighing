package com.smart.app.weighing.controller.web;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@Value("${application.title}")
	private String applicationTitle;
	
	@RequestMapping("/home")
	public String home(Model model) {
		model.addAttribute("applicationTitle", applicationTitle);
		return "index";
	}
	
	@RequestMapping("/home/page")
	public String index(Model model) {
		model.addAttribute("applicationTitle", applicationTitle);
		return "pages/home";
	}
	
	@GetMapping("/403")
    public String error403() {
        return "/error/403";
    }
	
	@GetMapping("/history/page")
	public String historique(Model model) {
		
		model.addAttribute("histories", Collections.EMPTY_LIST);
		model.addAttribute("actionName", "historique");
		return "pages/historique";
	}
}
