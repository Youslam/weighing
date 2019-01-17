package com.smart.app.weighing.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.smart.app.weighing.dao.PesageRepository;
import com.smart.app.weighing.model.Pesage;
import com.smart.app.weighing.service.PesageService;

@Service
public class PesageServiceImpl implements PesageService {

	@Autowired
	PesageRepository pesageRepository;
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

}
