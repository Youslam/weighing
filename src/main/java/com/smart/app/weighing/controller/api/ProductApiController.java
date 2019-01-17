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

import com.smart.app.weighing.model.Product;
import com.smart.app.weighing.service.ProductService;
import com.smart.app.weighing.utils.LabelValuePair;

@RestController
@RequestMapping("/api/product")
public class ProductApiController {

	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	ProductService productService;
	
	@PostMapping("/save")
	public Product save(Product product) {
		return productService.saveOrUpdate(product);
	}
	
	@GetMapping("/findOne")
	public Product findOne(Long id) {
		return productService.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid Product Id:" + id));
	}
	
	@RequestMapping(value="/search")
	public List<LabelValuePair> plantNamesAutocomplete(@RequestParam(value="term", required = false, defaultValue="") String term)  {
		List<LabelValuePair> suggestions = new ArrayList<>();
		List<Product> productList = new ArrayList<>();
		try {
			// only update when term is three characters.
			if (term.length() >= 2) {
				productList.addAll(productService.searchProducts(term));
			}
			for(Product product: productList) {
				suggestions.add(new LabelValuePair(product.getName(), String.valueOf(product.getId())));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Exception in autocomplete", e);
		}
		return suggestions;
	}
}
