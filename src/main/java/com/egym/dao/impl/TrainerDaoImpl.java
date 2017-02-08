package com.egym.dao.impl;

import com.egym.dao.TrainerDao;
import com.egym.model.Authorities;
import com.egym.model.Client;
import com.egym.model.Trainer;
import com.egym.model.Users;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by MichaelMAC on 14.01.17.
 */
@Repository
@Transactional
public class TrainerDaoImpl implements TrainerDao {

    @Autowired
    private SessionFactory sessionFactory;

    /**
     * Add new trainer to database. New user and authority are also added to db.
     * @param trainer new trainer
     */
    public void addTrainer(Trainer trainer) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(trainer);

        //Adding new user
        Users newUser = new Users();
        newUser.setUsername(trainer.getUsername());
        newUser.setPassword(trainer.getPassword());
        newUser.setEnabled(true);
        newUser.setClientId(0);
        newUser.setTrainerId(trainer.getTrainerId());

        //Adding new authority
        Authorities newAuthority = new Authorities();
        newAuthority.setUsername(trainer.getUsername());
        newAuthority.setAuthority("ROLE_TRAINER");
        session.saveOrUpdate(newUser);
        session.saveOrUpdate(newAuthority);

        session.flush();
    }

    /**
     * Edit existed trainer into database
     * @param trainer existed trainer
     */
    public void editTrainer(Trainer trainer) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(trainer);
        session.flush();
    }

    /**
     * Retrieve trainer from database by his id
     * @param trainerId trainer id
     * @return appropriate trainer
     */
    public Trainer getTrainerById(int trainerId) {
        Session session = sessionFactory.getCurrentSession();
        return (Trainer) session.get(Trainer.class, trainerId);
    }

    /**
     * Retrieve all trainers from database
     * @return list of trainers
     */
    public List<Trainer> getAllTrainers() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Trainer");
        List<Trainer> trainerList = query.list();

        return trainerList;
    }

    /**
     * Retrieve trainer from database by his username
     * @param username trainer username
     * @return appropriate trainer
     */
    public Trainer getTrainerByUsername(String username) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Trainer where username = ?");
        query.setString(0, username);

        return (Trainer) query.uniqueResult();
    }
}
