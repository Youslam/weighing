package com.smart.app.weighing.controller.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.smart.app.weighing.model.Client;
import com.smart.app.weighing.service.ClientService;

@Controller
@RequestMapping("/client")
public class ClientController {

	@Autowired
	private ClientService clientService;
	
	@GetMapping("/page")
	public String clientList(Model model) {
		List<Client> clientList =  clientService.findAll();
		model.addAttribute("clientList", clientList);
		model.addAttribute("actionName", "clients");
		return "pages/client";
	}
	
	@PostMapping("/save")
	public String updateClient(Client client) {
		clientService.saveOrUpdate(client);
		return "redirect:/client/page";
	}
	
	@GetMapping("/delete")
	public String deleteClient(long id) {
		clientService.deleteById(id);
		return "redirect:/client/page";
	}
	
	@GetMapping("/findOne")
	@ResponseBody
	public Client findOne(Long id) {
		return clientService.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid Client Id:" + id));
	}
}
