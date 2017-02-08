package com.egym.service.impl;

import com.egym.dao.ClientDao;
import com.egym.model.Client;
import com.egym.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by MichaelMAC on 11.01.17.
 */
@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientDao clientDao;

    /**
     * Add new client to database. Also new user and authority is added.
     * @param client client to be added
     */
    public void addClient(Client client) {
        clientDao.addClient(client);
    }

    /**
     * Edit client info into database
     * @param client client to be edited
     */
    public void editClient(Client client) {
        clientDao.editClient(client);
    }

    /**
     * Retrieve the client by id from database
     * @param clientId id of client
     * @return Client with appropriate id
     */
    public Client getClientById(int clientId) {
        return clientDao.getClientById(clientId);
    }

    /**
     * Retrieve all clients from database
     * @return list of clients
     */
    public List<Client> getAllClients() {
        return clientDao.getAllClients();
    }

    /**
     * Retrieve the client by username from database
     * @param username username of client
     * @return Client with appropriate username
     */
    public Client getClientByUsername(String username) {
        return clientDao.getClientByUsername(username);
    }
}
