package com.smart.app.weighing.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smart.app.weighing.dao.VehicleRepository;
import com.smart.app.weighing.model.Vehicle;
import com.smart.app.weighing.service.VehicleService;

@Service
@Transactional
public class VehicleServiceImpl implements VehicleService {

	private static final Integer PAGE_SIZE = 5;
	@Autowired
	VehicleRepository vehicleRepository;
	
	@Override
	public List<Vehicle> findAll() {
		return vehicleRepository.findAll();
	}
	
	@Override
	public Page<Vehicle> findAll(int page) {
		return vehicleRepository.findAll(PageRequest.of(page, PAGE_SIZE));
	}

	@Override
	public Optional<Vehicle> findById(Long id) {
		return vehicleRepository.findById(id);
	}

	@Override
	public Vehicle saveOrUpdate(Vehicle vehicle) {
		return vehicleRepository.save(vehicle);
	}

	@Override
	public void deleteById(Long id) {
		vehicleRepository.deleteById(id);
	}
	
	@Override
	public void delete(Vehicle vehicle) {
		vehicleRepository.delete(vehicle);
	}
	
	@Override
	public List<Vehicle> searchVehicle(String term) {
		return vehicleRepository.findByMatriculeContaining(term);
	}

}
