package com.smart.app.weighing.controller.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.smart.app.weighing.model.Pesage;
import com.smart.app.weighing.service.PesageService;

@Controller
@RequestMapping("/history")
public class PesageController {

	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PesageService pesageService;
	
	@GetMapping("/page")
	public String findAll(Model model, @RequestParam(defaultValue="0") int page) {
		Page<Pesage> historyList =  pesageService.findAll(PageRequest.of(page, 2, orderByDateDesc()));
		model.addAttribute("histories", historyList);
		model.addAttribute("actionName", "historique");
		model.addAttribute("total", historyList.getTotalPages());
		model.addAttribute("currentPage", page);
		return "pages/historique";
	}
	
	private Sort orderByDateDesc() {
		return new Sort(Sort.Direction.DESC, "dateTime");
	}
}
