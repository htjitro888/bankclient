package com.ht.bankclient.bankclient.DAO;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ht.bankclient.bankclient.model.Client;

@Repository
public interface MongoDBClientRepository  extends MongoRepository<Client, UUID>{

}
