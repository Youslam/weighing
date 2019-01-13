package com.smart.app.weighing.controller.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.smart.app.weighing.model.Vehicle;
import com.smart.app.weighing.service.VehicleService;

@Controller
@RequestMapping("/vehicle")
public class VehicleController {

	@Autowired
	private VehicleService vehicleService;
	
	@ResponseBody
    @GetMapping(value = "/loadEntity/{id}")
    public Vehicle loadEntity(@PathVariable("id") Long id) {
        return vehicleService.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Vehicle Id:" + id));
    }

    @ResponseBody
    @GetMapping(value = "/loadVehicleTable")
    public List<Vehicle> loadVehicleTable() {
        return vehicleService.findAll();
    }
	
	@GetMapping("/page")
	public String vehicleList(@Valid @ModelAttribute("vehicle") Vehicle vehicle, BindingResult result, Model model) {
		model.addAttribute("vehicleList", vehicleService.findAll());
		model.addAttribute("actionName", "vehicles");
		model.addAttribute("vehicle", new Vehicle());
		return "pages/vehicule";
	}
	
	@GetMapping("/edit/{id}")
	public String editModalContents(@PathVariable("id") Long id, ModelMap modelMap) {
		Vehicle vehicle = vehicleService.findById(id)
			      .orElseThrow(() -> new IllegalArgumentException("Invalid Vehicle Id:" + id));
		modelMap.addAttribute("vehicle", vehicle);
		return "pages/vehicle::editModalContents";
	}
	
	@PostMapping("/add")
	public String addVehicle(@Valid Vehicle vehicle, BindingResult result, Model model) {
		if(result.hasErrors()) {
			System.err.println("Error adding vehicle");
			return "pages/vehicule";
		}
		
		vehicleService.saveOrUpdate(vehicle);
		model.addAttribute("vehicleList", vehicleService.findAll());
		model.addAttribute("actionName", "vehicles");
		return "pages/vehicule";
	}
	
	@PostMapping("/update/{id}")
	public String updateVehicle(@PathVariable("id") Long id, @Valid Vehicle vehicle, BindingResult result, Model model) {
		if(result.hasErrors()) {
			vehicle.setId(id);
	        return "update-user";
		}
		
		vehicleService.saveOrUpdate(vehicle);
		model.addAttribute("vehicleList", vehicleService.findAll());
		model.addAttribute("actionName", "vehicles");
		return "pages/vehicule";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") long id, Model model) {
		Vehicle vehicle = vehicleService.findById(id)
	      .orElseThrow(() -> new IllegalArgumentException("Invalid Vehicle Id:" + id));
		vehicleService.delete(vehicle);
	    model.addAttribute("vehicleList", vehicleService.findAll());
	    model.addAttribute("actionName", "vehicles");
	    return "pages/vehicule";
	}
}
