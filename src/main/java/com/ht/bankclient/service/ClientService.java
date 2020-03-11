package com.ht.bankclient.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ht.bankclient.DAO.ClientDAO;
import com.ht.bankclient.model.Account;
import com.ht.bankclient.model.Address;
import com.ht.bankclient.model.Client;

@Service
public class ClientService {
	ClientDAO DB;

	@Autowired
	public ClientService(@Qualifier("MongoDB") ClientDAO dB) {
		super();
		DB = dB;
	}
	
	public List<Client> getClients() {
		return DB.getClients();
	}
	
	public void addClient(Client client) {
		DB.addClient(client);
	}
	
	public Client getById(UUID id) {
		return DB.getById(id);
	}
	public void addAddress(UUID id, Address address) {
		DB.addAddress(id, address);
	}
	public void addAccount(UUID id, Account account) {
		DB.addAccount(id, account);
	}
	public List<Client> query(boolean hasAddress, boolean hasAccount) {
		return DB.query(hasAddress, hasAccount);
	}
	public void deleteClientById(UUID id) {
		DB.delete(id);
	}
	public void clearAll() {
		DB.deleteAll();
	}
}
