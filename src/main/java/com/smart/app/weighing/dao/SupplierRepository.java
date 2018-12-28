package com.smart.app.weighing.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smart.app.weighing.model.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {

}
