package com.smart.app.weighing.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.smart.app.weighing.model.Product;

public interface ProductService {

	/**
	 * find all products
	 * @return {@link List} of vehicules
	 */
	List<Product> findAll();
	
	/**
	 * find a specific product by id
	 * @param id
	 * @return a specific  product
	 */
	Optional<Product> findById(Long id);
	
	/**
	 * save or update a product
	 * @param product
	 */
	Product saveOrUpdate(Product product);
	
	/**
	 * delete a specific product by id
	 * @param id
	 */
	void deleteById(Long id);
	
	/**
	 * delete a specific product by product object
	 * @param product
	 */
	void delete(Product product);

	/**
	 * Find all products and showing by page
	 * @param page
	 * @return
	 */
	Page<Product> findAll(int page);

	/**
	 * Search products by name for auto completion
	 * @param term
	 * @return
	 */
	List<Product> searchProducts(String term);
}
