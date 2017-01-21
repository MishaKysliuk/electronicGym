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

    public void addClient(Client client) {
        clientDao.addClient(client);
    }

    public void editClient(Client client) {
        clientDao.editClient(client);
    }

    public Client getClientById(int clientId) {
        return clientDao.getClientById(clientId);
    }

    public List<Client> getAllClients() {
        return clientDao.getAllClients();
    }

    public Client getClientByUsername(String username) {
        return clientDao.getClientByUsername(username);
    }
}
