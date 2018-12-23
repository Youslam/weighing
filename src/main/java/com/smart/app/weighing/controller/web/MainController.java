package com.smart.app.weighing.controller.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@Value("${application.title}")
	private String applicationTitle;
	
	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("applicationTitle", applicationTitle);
		return "index";
	}
	
	@RequestMapping("/pages/index")
	public String index(Model model) {
		model.addAttribute("applicationTitle", applicationTitle);
		return "pages/index";
	}
}
