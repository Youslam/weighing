package com.smart.app.weighing.service;

import java.util.List;
import java.util.Optional;

import com.smart.app.weighing.model.Vehicle;

public interface VehicleService {

	/**
	 * find all vehicles
	 * @return {@link List} of vehicules
	 */
	List<Vehicle> findAll();
	
	/**
	 * find a specific vehicle by id
	 * @param id
	 * @return a specific  vehicle
	 */
	Optional<Vehicle> findById(Long id);
	
	/**
	 * save or update a vehicle
	 * @param vehicle
	 */
	void saveOrUpdate(Vehicle vehicle);
	
	/**
	 * delete a specific vehicle by id
	 * @param id
	 */
	void deleteById(Long id);
	
	/**
	 * delete a specific vehicle by vehicle object
	 * @param vehicle
	 */
	void delete(Vehicle vehicle);
}
