package com.ht.bankclient.common;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.ht.bankclient.model.Account;
import com.ht.bankclient.model.Address;
import com.ht.bankclient.model.Bank;
import com.ht.bankclient.model.Client;
import com.ht.bankclient.model.Person;

public class Generate {

	
	public static Client client() {
		Address personAddr = new Address("12 Jarupa Street", null, "San Diego", "CA", "92001", "USA", "Main");
		Address bankAddr = new Address("1 Main Street", "Suite A", "San Diego", "CA", "92021", "USA", "Main");
		Bank bank = new Bank("Bank of The World", "2098080", bankAddr);
		Account account = new Account(bank, Integer.valueOf(1112092), "Savings", Long.valueOf(2500));
		Person person = new Person("John", "Fist", "Male", Date.valueOf("1960-12-13"));
		List<Address> addresses = new ArrayList<Address>();
		List<Account> accounts = new ArrayList<Account>();
		addresses.add(personAddr);
		accounts.add(account);
		
		Client client = new Client(UUID.randomUUID(), person, addresses, accounts);
		return client;
	}
}
