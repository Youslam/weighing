package com.smart.app.weighing.controller.api;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smart.app.weighing.model.Pesage;
import com.smart.app.weighing.service.PesageService;

@RestController
@RequestMapping("/api/pesage")
public class PesageApiController {

	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PesageService pesageService;
	
	@PostMapping("/save")
	public void save(Pesage pesage) {
		pesage.setDateTime(new Date());
		pesageService.save(pesage);
	}
}
