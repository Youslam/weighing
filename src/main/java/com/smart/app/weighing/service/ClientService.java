package com.smart.app.weighing.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.smart.app.weighing.model.Client;

public interface ClientService {

	/**
	 * find all clients
	 * @return {@link List} of vehicules
	 */
	List<Client> findAll();
	
	/**
	 * find a specific client by id
	 * @param id
	 * @return a specific  client
	 */
	Optional<Client> findById(Long id);
	
	/**
	 * save or update a client
	 * @param client
	 */
	void saveOrUpdate(Client client);
	
	/**
	 * delete a specific client by id
	 * @param id
	 */
	void deleteById(Long id);
	
	/**
	 * delete a specific client by client object
	 * @param client
	 */
	void delete(Client client);

	/**
	 * Find all clients and showing by page
	 * @param page
	 * @return
	 */
	Page<Client> findAll(int page);
}
