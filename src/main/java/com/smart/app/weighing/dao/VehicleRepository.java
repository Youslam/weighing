package com.smart.app.weighing.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.smart.app.weighing.model.Vehicle;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

	@Query("SELECT matricule FROM Vehicle WHERE matricule LIKE '%' || :term || '%'")
	public List<String> searchVehicle(@Param("term") String term);
	
	List<Vehicle> findByMatriculeContaining(String matricule);
}
