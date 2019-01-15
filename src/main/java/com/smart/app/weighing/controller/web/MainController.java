package com.smart.app.weighing.controller.web;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.smart.app.weighing.model.Vehicle;
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
	
	@GetMapping("/history/page")
	public String historique(Model model) {
		
		model.addAttribute("histories", Collections.EMPTY_LIST);
		model.addAttribute("actionName", "historique");
		return "pages/historique";
	}
	
	@RequestMapping(value="/home/vehicle/search")
	@ResponseBody
	public List<String> plantNamesAutocomplete(@RequestParam(value="term", required = false, defaultValue="") String term)  {
		List<String> suggestions = new ArrayList<String>();
		List<Vehicle> vehicleList = new ArrayList<>();
		try {
			// only update when term is three characters.
			if (term.length() == 2) {
				//firstThreeCharacters = term;
				vehicleList.addAll(vehicleService.searchVehicle(term));
			}
			for(Vehicle vehicle: vehicleList) {
				suggestions.add(vehicle.getMatricule());
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error("Exception in autocomplete", e);
		}
		
		return suggestions;
		
	}
}
