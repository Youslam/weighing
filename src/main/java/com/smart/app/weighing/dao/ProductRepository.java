package com.smart.app.weighing.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.smart.app.weighing.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	List<Product> findByNameContaining(String term);
	
	@Query("SELECT p FROM Product p WHERE p.name LIKE '%' || :term || '%'")
	public List<Product> searchProductByName(@Param("term") String term);
}
