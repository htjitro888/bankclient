package com.ht.bankclient.bankclient.DAO;

import java.util.List;
import java.util.UUID;

import com.ht.bankclient.bankclient.model.Account;
import com.ht.bankclient.bankclient.model.Address;
import com.ht.bankclient.bankclient.model.Client;

public interface ClientDAO {
	List<Client> getClients();
	
	void addClient(UUID id, Client client);
	
	default void addClient(Client client) {
		UUID id = UUID.randomUUID();
		addClient(id, client);		
	}
	
	void addAddress(UUID id, Address address);
	void addAccount(UUID id, Account account);
	
	Client getById(UUID id);
	
	List<Client> query(boolean hasAddress, boolean hasAccount);
	
	void delete(UUID id);
	void deleteAll();
}
