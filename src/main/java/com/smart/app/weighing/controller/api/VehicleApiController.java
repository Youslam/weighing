package com.smart.app.weighing.controller.api;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smart.app.weighing.model.Vehicle;
import com.smart.app.weighing.service.VehicleService;

@RestController
@RequestMapping("/api/vehicle")
public class VehicleApiController {
	
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	VehicleService vehicleService;

	@PostMapping("/save")
	public void save(Vehicle vehicle) {
		vehicleService.saveOrUpdate(vehicle);
	}
	
	@GetMapping("/findOne")
	public Vehicle findOne(Long id) {
		return vehicleService.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid Vehicle Id:" + id));
	}
	
	@RequestMapping(value="/search")
	public List<String> plantNamesAutocomplete(@RequestParam(value="term", required = false, defaultValue="") String term)  {
		List<String> suggestions = new ArrayList<String>();
		List<Vehicle> vehicleList = new ArrayList<>();
		try {
			// only update when term is three characters.
			if (term.length() == 2) {
				vehicleList.addAll(vehicleService.searchVehicle(term));
			}
			for(Vehicle vehicle: vehicleList) {
				suggestions.add(vehicle.getMatricule());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Exception in autocomplete", e);
		}
		return suggestions;
	}
}
