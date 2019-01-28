package com.smart.app.weighing.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.smart.app.weighing.model.Pesage;

public interface PesageService {

	/**
	 * save history for pesage
	 * @param pesage 
	 * 
	 */
	void save(Pesage pesage);
	
	/**
	 * Find all weighing history
	 * 
	 * @return
	 */
	List<Pesage> findAll();
	
	/**
	 * Find all weighing history by page
	 * 
	 * @param pageable
	 * @return
	 */
	Page<Pesage> findAll(Pageable pageable);
}
