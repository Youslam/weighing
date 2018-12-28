package com.smart.app.weighing.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smart.app.weighing.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
