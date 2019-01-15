package com.smart.app.weighing.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.smart.app.weighing.dao.SupplierRepository;
import com.smart.app.weighing.model.Supplier;
import com.smart.app.weighing.service.SupplierService;

@Service
public class SupplierServiceImpl implements SupplierService {

	private static final Integer PAGE_SIZE = 5;
	@Autowired
	SupplierRepository supplierRepository;
	
	@Override
	public List<Supplier> findAll() {
		return supplierRepository.findAll();
	}
	
	@Override
	public Page<Supplier> findAll(int page) {
		return supplierRepository.findAll(PageRequest.of(page, PAGE_SIZE));
	}

	@Override
	public Optional<Supplier> findById(Long id) {
		return supplierRepository.findById(id);
	}

	@Override
	public void saveOrUpdate(Supplier supplier) {
		supplierRepository.save(supplier);
	}

	@Override
	public void deleteById(Long id) {
		supplierRepository.deleteById(id);
	}
	
	@Override
	public void delete(Supplier supplier) {
		supplierRepository.delete(supplier);
	}

}
