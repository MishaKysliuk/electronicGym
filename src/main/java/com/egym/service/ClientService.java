package com.egym.service;

import com.egym.model.Client;

import java.util.List;

/**
 * Created by MichaelMAC on 11.01.17.
 */
public interface ClientService {

    /**
     * Add new client to database. Also new user and authority is added.
     * @param client client to be added
     */
    void addClient (Client client);

    /**
     * Edit client info into database
     * @param client client to be edited
     */
    void editClient(Client client);

    /**
     * Retrieve the client by id from database
     * @param clientId id of client
     * @return Client with appropriate id
     */
    Client getClientById (int clientId);

    /**
     * Retrieve all clients from database
     * @return list of clients
     */
    List<Client> getAllClients();

    /**
     * Retrieve the client by username from database
     * @param username username of client
     * @return Client with appropriate username
     */
    Client getClientByUsername (String username);
}
