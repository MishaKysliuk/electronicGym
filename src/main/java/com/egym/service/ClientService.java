package com.egym.service;

import com.egym.model.Client;

import java.util.List;

/**
 * Created by MichaelMAC on 11.01.17.
 */
public interface ClientService {

    void addClient (Client client);

    void editClient (Client client);

    Client getClientById (int clientId);

    List<Client> getAllClients();

    Client getClientByUsername (String username);
}
