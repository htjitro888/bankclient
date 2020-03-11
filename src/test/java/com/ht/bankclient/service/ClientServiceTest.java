package com.ht.bankclient.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import com.ht.bankclient.DAO.InMemoryClientDAO;
import com.ht.bankclient.common.Generate;
import com.ht.bankclient.model.Client;
import com.ht.bankclient.service.ClientService;

class ClientServiceTest {
	
	Client defaultClient = null;
				
	ClientService service = new ClientService(new InMemoryClientDAO());

	@BeforeEach
	void setUp() throws Exception {
		defaultClient = Generate.client();
		List<Client> clients = new ArrayList<Client>();
		clients.add(defaultClient);
		
	}

	@Test
	void test() {
		service.addClient(defaultClient);
		List<Client> clients = service.getClients();
		Assert.isTrue(clients.size()==1);
	}

}
