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

import com.smart.app.weighing.model.Client;
import com.smart.app.weighing.service.ClientService;
import com.smart.app.weighing.utils.LabelValuePair;

@RestController
@RequestMapping("/api/client")
public class ClientApiController {

	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	ClientService clientService;
	
	@PostMapping("/save")
	public Client save(Client client) {
		return clientService.saveOrUpdate(client);
	}
	
	@GetMapping("/findOne")
	public Client findOne(Long id) {
		return clientService.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid Client Id:" + id));
	}
	
	@RequestMapping(value="/search")
	public List<LabelValuePair> plantNamesAutocomplete(@RequestParam(value="term", required = false, defaultValue="") String term)  {
		List<LabelValuePair> suggestions = new ArrayList<>();
		List<Client> clientList = new ArrayList<>();
		try {
			// only update when term is three characters.
			if (term.length() == 2) {
				clientList.addAll(clientService.searchClients(term));
			}
			for(Client client: clientList) {
				suggestions.add(new LabelValuePair(client.getName(), String.valueOf(client.getId())));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Exception in autocomplete", e);
		}
		return suggestions;
	}
}
