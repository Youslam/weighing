package com.smart.app.weighing.controller.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.smart.app.weighing.service.VehicleService;

@Controller
public class MainController {
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	VehicleService vehicleService;

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
}
