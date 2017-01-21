package com.egym.dao.impl;

import com.egym.dao.ClientDao;
import com.egym.model.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by MichaelMAC on 11.01.17.
 */
@Repository
@Transactional
public class ClientDaoImpl implements ClientDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void addClient(Client client) {
        Session session = sessionFactory.getCurrentSession();
        ClientPersonalCard clientPersonalCard = new ClientPersonalCard();
        client.setClientCard(clientPersonalCard);
        session.saveOrUpdate(client);

        Users newUser = new Users();
        newUser.setUsername(client.getUsername());
        newUser.setPassword(client.getPassword());
        newUser.setEnabled(true);
        newUser.setClientId(client.getClientId());
        newUser.setTrainerId(0);

        Authorities newAuthority = new Authorities();
        newAuthority.setUsername(client.getUsername());
        newAuthority.setAuthority("ROLE_USER");
        session.saveOrUpdate(newUser);
        session.saveOrUpdate(newAuthority);

        session.flush();
    }

    public void editClient(Client client) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(client);
        session.flush();
    }

    public Client getClientById(int clientId) {
        Session session = sessionFactory.getCurrentSession();
        return (Client) session.get(Client.class, clientId);
    }

    public List<Client> getAllClients() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Client");
        List<Client> clientList = query.list();

        return clientList;
    }

    public Client getClientByUsername(String username) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Client where username = ?");
        query.setString(0, username);

        return (Client) query.uniqueResult();
    }
}
