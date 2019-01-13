package com.smart.app.weighing.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.app.weighing.dao.VehicleRepository;
import com.smart.app.weighing.model.Vehicle;
import com.smart.app.weighing.service.VehicleService;

@Service
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	VehicleRepository vehicleRepository;
	
	@Override
	public List<Vehicle> findAll() {
//		if(vehicleRepository.findAll() != null) {
			return vehicleRepository.findAll();
//		}
//		return Collections.emptyList();
	}

	@Override
	public Optional<Vehicle> findById(Long id) {
		return vehicleRepository.findById(id);
	}

	@Override
	public void saveOrUpdate(Vehicle vehicle) {
		vehicleRepository.save(vehicle);
	}

	@Override
	public void deleteById(Long id) {
		vehicleRepository.deleteById(id);
	}
	
	@Override
	public void delete(Vehicle vehicle) {
		vehicleRepository.delete(vehicle);
	}

}
