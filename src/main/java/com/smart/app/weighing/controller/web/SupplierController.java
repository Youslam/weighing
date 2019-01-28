package com.smart.app.weighing.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.smart.app.weighing.model.Supplier;
import com.smart.app.weighing.service.SupplierService;

@Controller
@RequestMapping("/supplier")
public class SupplierController {

	@Autowired
	SupplierService supplierService;
	
	@GetMapping("/page")
	public String delivryList(Model model) {
		model.addAttribute("supplierList", supplierService.findAll());
		model.addAttribute("actionName", "suppliers");
		return "pages/fournisseur";
	}
	
	@PostMapping("/save")
	public String saveSupplier(Supplier supplier) {
		supplierService.saveOrUpdate(supplier);
		return "redirect:/supplier/page";
	}
	
	@GetMapping("/delete")
	public String deleteSupplier(Long id) {
		supplierService.deleteById(id);
		return "redirect:/supplier/page";
	}
	
	@GetMapping("/findOne")
	@ResponseBody
	public Supplier findOne(Long id) {
		return supplierService.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Supplier Id: " + id));
	}
	
}
