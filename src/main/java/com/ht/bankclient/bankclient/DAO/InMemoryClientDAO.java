package com.ht.bankclient.bankclient.DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.ht.bankclient.bankclient.model.Account;
import com.ht.bankclient.bankclient.model.Address;
import com.ht.bankclient.bankclient.model.Client;

@Repository("InMemory")
public class InMemoryClientDAO implements ClientDAO {

	List<Client> DB = new ArrayList<Client>();
	
	@Override
	public List<Client> getClients() {
		return DB;
	}

	@Override
	public void addClient(UUID id, Client client) {
		Client newClient = new Client(id, client.getPerson(), client.getAddresses(), client.getAccounts());
		DB.add(newClient);
	}

	
	@Override
	public Client getById(UUID id) {
		for (Client client : DB) {
			if (client==null) continue;
			if (client.getId().equals(id))
				return client;
		}
		return null;
	}

	@Override
	public void addAddress(UUID id, Address address) {
		Client foundClient = getById(id);
		if (foundClient!=null)
			foundClient.addAddress(address);
	}

	@Override
	public void addAccount(UUID id, Account account) {
		Client foundClient = getById(id);
		if (foundClient!=null)
			foundClient.addAccount(account);
		
	}

	@Override
	public List<Client> query(boolean hasAddress, boolean hasAccount) {
		List<Client> response = new ArrayList<Client>();
		
		for (Client client : DB) {
			boolean foundAddress = (client.getAddresses()!=null && client.getAddresses().size()>0) ? true : false;
			boolean foundAccount = (client.getAccounts()!=null && client.getAccounts().size()>0) ? true : false;
			
			if ((hasAddress && hasAccount) && (foundAddress && foundAccount))
				response.add(client);
			
			if ((hasAddress && !hasAccount) && (foundAddress && !foundAccount))
				response.add(client);

			if ((!hasAddress && hasAccount) && (!foundAddress && foundAccount))
				response.add(client);
		}
		return response;
	}

	@Override
	public void delete(UUID id) {
		for (int i=0; i<DB.size(); i++) {
			Client client = DB.get(i);
			if (client.getId().equals(id)) {
				DB.remove(i);
				break;
			}				
		}			
	}

	@Override
	public void deleteAll() {
		DB.clear();		
	}

	
}
