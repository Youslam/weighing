package com.smart.app.weighing.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.smart.app.weighing.dao.ClientRepository;
import com.smart.app.weighing.dao.PesageRepository;
import com.smart.app.weighing.dao.ProductRepository;
import com.smart.app.weighing.dao.SupplierRepository;
import com.smart.app.weighing.dao.VehicleRepository;
import com.smart.app.weighing.model.Client;
import com.smart.app.weighing.model.Pesage;
import com.smart.app.weighing.model.Product;
import com.smart.app.weighing.model.Supplier;
import com.smart.app.weighing.model.Vehicle;
import com.smart.app.weighing.service.PesageService;

@Service
public class PesageServiceImpl implements PesageService {

	@Autowired
	PesageRepository pesageRepository;
	@Autowired
	VehicleRepository vehicleRepository;
	@Autowired
	ProductRepository productRepository;
	@Autowired
	ClientRepository clientRepository;
	@Autowired
	SupplierRepository supplierRepository;
	
	@Override
	public void save(Pesage pesage) {
		pesageRepository.save(pesage);
	}

	@Override
	public List<Pesage> findAll() {
		return pesageRepository.findAll();
	}

	@Override
	public Page<Pesage> findAll(Pageable pageable) {
		return pesageRepository.findAll(pageable);
	}
	
	@Override
	public List<Pesage> searchPesageByTerm(String filter, String term) {
		List<Pesage> pesage = new ArrayList<>();
		switch (filter) {
		case "vehicle":
			List<Vehicle> vehicles = vehicleRepository.searchVehicleByMatricule(term);
			pesage = pesageRepository.findByVehicleIn(vehicles);
			break;
		case "product":
			List<Product> products = productRepository.searchProductByName(term);
			pesage = pesageRepository.findByProductIn(products);
			break;
		case "client":
			List<Client> clients = clientRepository.searchClientByName(term);
			pesage = pesageRepository.findByClientIn(clients);
			break;
		case "supplier":
			List<Supplier> suppliers = supplierRepository.searchSupplierByName(term);
			pesage = pesageRepository.findBySupplierIn(suppliers);
			break;
		}
		
		return pesage;
	}
}
