package com.ht.bankclient.bankclient.DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.ht.bankclient.bankclient.model.Account;
import com.ht.bankclient.bankclient.model.Address;
import com.ht.bankclient.bankclient.model.Client;

@Repository("MongoDB")
public class MongoDBClientDAO implements ClientDAO{
    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    MongoDBClientRepository repository;

	@Override
	public List<Client> getClients() {
		return repository.findAll();
	}

	@Override
	public void addClient(UUID id, Client client) {
		Client newClient = new Client(id, client.getPerson(), client.getAddresses(), client.getAccounts());
		repository.save(newClient);
	}

	@Override
	public void addAddress(UUID id, Address address) {
		Client foundClient = getById(id);
		if (foundClient!=null) {
			foundClient.addAddress(address);
			repository.save(foundClient);
		}		
	}

	@Override
	public void addAccount(UUID id, Account account) {
		Client foundClient = getById(id);
		if (foundClient!=null) {
			foundClient.addAccount(account);;
			repository.save(foundClient);
		}		
	}

	@Override
	public Client getById(UUID id) {
    	Query query = new Query();
    	query.addCriteria(Criteria.where("id").is(id));
    	List<Client> foundClients = mongoTemplate.find(query, Client.class);
    	if (foundClients!=null && foundClients.size()>0)
    		return foundClients.get(0);

		return null;
	}

	@Override
	public List<Client> query(boolean hasAddress, boolean hasAccount) {
		// TODO Auto-generated method stub
		List<Client> clients = repository.findAll();

		List<Client> response = new ArrayList<Client>();
		
		for (Client client : clients) {
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
		// TODO Auto-generated method stub
		repository.deleteById(id);		
	}

	@Override
	public void deleteAll() {
		repository.deleteAll();		
	}
    
    
}
