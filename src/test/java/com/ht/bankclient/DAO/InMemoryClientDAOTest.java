package com.ht.bankclient.DAO;


import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import com.ht.bankclient.bankclient.DAO.InMemoryClientDAO;
import com.ht.bankclient.bankclient.model.Client;
import com.ht.bankclient.common.Generate;

class InMemoryClientDAOTest {

	Client defaultClient = null;
	
	InMemoryClientDAO dao = new InMemoryClientDAO();
	
	
	@BeforeEach
	void setUp() throws Exception {
		defaultClient = Generate.client();
	}

	@Test
	void test() {
		
		dao.addClient(defaultClient);
		dao.addClient(defaultClient);
		List<Client> clients = dao.getClients();
		Assert.isTrue(clients.size()==2, "There are two clients");
	}

}
