package com.smart.app.weighing.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.smart.app.weighing.model.Vehicle;
import com.smart.app.weighing.service.VehicleService;

@Controller
@RequestMapping("/vehicle")
public class VehicleController {

	@Autowired
	private VehicleService vehicleService;
	
	@GetMapping("/page")
	public String vehicleList(Model model, @RequestParam(defaultValue="0") int page) {
		Page<Vehicle> vehicleList =  vehicleService.findAll(page);
		model.addAttribute("vehicleList", vehicleList);
		model.addAttribute("actionName", "vehicles");
		model.addAttribute("total", vehicleList.getTotalPages());
		model.addAttribute("currentPage", page);
		return "pages/vehicule";
	}
	
	@PostMapping("/save")
	public String updateVehicle(Vehicle vehicle) {
		vehicleService.saveOrUpdate(vehicle);
		return "redirect:/vehicle/page";
	}
	
	@GetMapping("/delete")
	public String deleteVehicle(long id) {
		vehicleService.deleteById(id);
		return "redirect:/vehicle/page";
	}
	
	@GetMapping("/findOne")
	@ResponseBody
	public Vehicle findOne(Long id) {
		return vehicleService.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid Vehicle Id:" + id));
	}
}
