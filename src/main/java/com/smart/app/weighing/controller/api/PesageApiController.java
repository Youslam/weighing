package com.smart.app.weighing.controller.api;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smart.app.weighing.export.ExcelGenerator;
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
	
	@GetMapping(value = "/download/excel")
    public ResponseEntity<InputStreamResource> excelCustomersReport() throws IOException {
        List<Pesage> customers = (List<Pesage>) pesageService.findAll();
		
		ByteArrayInputStream in = ExcelGenerator.pesagesToExcel(customers);
		// return IOUtils.toByteArray(in);
		
		HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=pesages.xlsx");
		
		 return ResponseEntity
	                .ok()
	                .headers(headers)
	                .body(new InputStreamResource(in));
    }

	
}
