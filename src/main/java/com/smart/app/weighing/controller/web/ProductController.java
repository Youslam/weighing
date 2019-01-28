package com.smart.app.weighing.controller.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.smart.app.weighing.model.Product;
import com.smart.app.weighing.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("/page")
	public String productList(Model model) {
		List<Product> productList =  productService.findAll();
		model.addAttribute("productList", productList);
		model.addAttribute("actionName", "products");
		return "pages/produit";
	}
	
	@PostMapping("/save")
	public String updateProduct(Product product) {
		productService.saveOrUpdate(product);
		return "redirect:/product/page";
	}
	
	@GetMapping("/delete")
	public String deleteProduct(long id) {
		productService.deleteById(id);
		return "redirect:/product/page";
	}
}
