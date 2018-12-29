package com.smart.app.weighing.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smart.app.weighing.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
