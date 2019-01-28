package com.smart.app.weighing.controller.api;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smart.app.weighing.model.Supplier;
import com.smart.app.weighing.service.SupplierService;
import com.smart.app.weighing.utils.LabelValuePair;

@RestController
@RequestMapping("/api/supplier")
public class SupplierApiController {

	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	SupplierService supplierService;
	
	@PostMapping("/save")
	public Supplier save(Supplier supplier) {
		return supplierService.saveOrUpdate(supplier);
	}
	
	@GetMapping("/findOne")
	public Supplier findOne(Long id) {
		return supplierService.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid Supplier Id:" + id));
	}
	
	@RequestMapping(value="/search")
	public List<LabelValuePair> plantNamesAutocomplete(@RequestParam(value="term", required = false, defaultValue="") String term)  {
		List<LabelValuePair> suggestions = new ArrayList<>();
		List<Supplier> supplierList = new ArrayList<>();
		try {
			// only update when term is three characters.
			if (term.length() == 2) {
				supplierList.addAll(supplierService.searchSuppliers(term));
			}
			for(Supplier supplier: supplierList) {
				suggestions.add(new LabelValuePair(supplier.getName(), String.valueOf(supplier.getId())));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Exception in autocomplete", e);
		}
		return suggestions;
	}
}
