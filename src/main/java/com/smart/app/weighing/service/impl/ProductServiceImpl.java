package com.smart.app.weighing.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smart.app.weighing.dao.ProductRepository;
import com.smart.app.weighing.model.Product;
import com.smart.app.weighing.service.ProductService;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	private static final Integer PAGE_SIZE = 5;
	@Autowired
	ProductRepository productRepository;
	
	@Override
	public List<Product> findAll() {
		return productRepository.findAll();
	}
	
	@Override
	public Page<Product> findAll(int page) {
		return productRepository.findAll(PageRequest.of(page, PAGE_SIZE));
	}

	@Override
	public Optional<Product> findById(Long id) {
		return productRepository.findById(id);
	}

	@Override
	public Product saveOrUpdate(Product product) {
		return productRepository.save(product);
	}

	@Override
	public void deleteById(Long id) {
		productRepository.deleteById(id);
	}
	
	@Override
	public void delete(Product product) {
		productRepository.delete(product);
	}

	@Override
	public List<Product> searchProducts(String term) {
		return productRepository.findByNameContaining(term);
	}

}
