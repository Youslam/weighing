package com.smart.app.weighing.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.smart.app.weighing.model.Supplier;

public interface SupplierService {

	/**
	 * find all suppliers
	 * 
	 * @return {@link List} of vehicules
	 */
	List<Supplier> findAll();
	
	/**
	 * find a specific supplier by id
	 * 
	 * @param id
	 * @return a specific  supplier
	 */
	Optional<Supplier> findById(Long id);
	
	/**
	 * save or update a supplier
	 * 
	 * @param supplier
	 */
	Supplier saveOrUpdate(Supplier supplier);
	
	/**
	 * delete a specific supplier by id
	 * 
	 * @param id
	 */
	void deleteById(Long id);
	
	/**
	 * delete a specific supplier by supplier object
	 * 
	 * @param supplier
	 */
	void delete(Supplier supplier);

	/**
	 * Find all suppliers and showing by page
	 * 
	 * @param page
	 * @return
	 */
	Page<Supplier> findAll(int page);

	/**
	 * Search suppliers by term name for auto completion
	 * 
	 * @param term
	 * @return
	 */
	Collection<? extends Supplier> searchSuppliers(String term);
}
