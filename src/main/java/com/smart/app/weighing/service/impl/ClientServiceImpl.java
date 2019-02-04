package com.smart.app.weighing.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smart.app.weighing.dao.ClientRepository;
import com.smart.app.weighing.model.Client;
import com.smart.app.weighing.service.ClientService;

@Service
@Transactional
public class ClientServiceImpl implements ClientService {

	private static final Integer PAGE_SIZE = 5;
	@Autowired
	ClientRepository clientRepository;
	
	@Override
	public List<Client> findAll() {
		return clientRepository.findAll();
	}
	
	@Override
	public Page<Client> findAll(int page) {
		return clientRepository.findAll(PageRequest.of(page, PAGE_SIZE));
	}

	@Override
	public Optional<Client> findById(Long id) {
		return clientRepository.findById(id);
	}

	@Override
	public Client saveOrUpdate(Client client) {
		return clientRepository.save(client);
	}

	@Override
	public void deleteById(Long id) {
		clientRepository.deleteById(id);
	}
	
	@Override
	public void delete(Client client) {
		clientRepository.delete(client);
	}

	@Override
	public List<Client> searchClients(String term) {
		return clientRepository.findByNameContaining(term);
	}

}
