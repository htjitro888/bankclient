package com.ht.bankclient.API;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ht.bankclient.model.Account;
import com.ht.bankclient.model.Address;
import com.ht.bankclient.model.Client;
import com.ht.bankclient.service.ClientService;

@RequestMapping("v1/bank/client")
@RestController
public class ClientController {

	ClientService service;

	@Autowired
	public ClientController(ClientService service) {
		super();
		this.service = service;
	}
	
	@GetMapping
	public List<Client> getClients() {
		return service.getClients();
	}
	
	@PostMapping
	public void addClient(@RequestBody Client client) {
		service.addClient(client);
	}
	
	@GetMapping(path="{id}")
	public Client getById(@PathVariable("id") UUID id) {
		return service.getById(id);
	}
	
	@PutMapping(path="{id}/address")
	public void addAddress(@PathVariable("id") UUID id, @RequestBody Address address) {
		service.addAddress(id, address);
	}
	
	@PutMapping(path="{id}/account")
	public void addAccount(@PathVariable("id") UUID id, @RequestBody Account account) {
		service.addAccount(id, account);
	}
	
	@GetMapping(path="query")
	public List<Client> query(@RequestParam(value="hasAddress", required=false) boolean hasAddress, 
			@RequestParam(value="hasAccount", required=false) boolean hasAccount) {
		
		return service.query(hasAddress, hasAccount);
	}
	
	@DeleteMapping(path="{id}")
	public void deleteClientById(@PathVariable("id") UUID id) {
		service.deleteClientById(id);
	}
	
	@DeleteMapping
	public void clearAll() {
		service.clearAll();
	}
}
