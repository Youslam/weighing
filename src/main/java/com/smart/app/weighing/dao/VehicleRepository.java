package com.smart.app.weighing.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smart.app.weighing.model.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

}
