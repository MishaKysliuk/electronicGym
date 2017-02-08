package com.egym.dao.impl;

import com.egym.dao.GymPassDao;
import com.egym.model.GymPass;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by MichaelMAC on 07.01.17.
 */

@Repository
@Transactional
public class GymPassDaoImpl implements GymPassDao {

    @Autowired
    private SessionFactory sessionFactory;


    /**
     * Add new gym pass to database
     * @param gymPass new gym pass
     */
    public void addGymPass(GymPass gymPass) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(gymPass);
        session.flush();
    }

    /**
     * Edit existed gym pass in database
     * @param gymPass existed pass
     */
    public void editGymPass(GymPass gymPass) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(gymPass);
        session.flush();
    }

    /**
     * Retrieve gym pass from database by its id
     * @param id id of gym pass
     * @return appropriate gym pass
     */
    public GymPass getGymPassById(int id) {
        Session session = sessionFactory.getCurrentSession();
        GymPass gymPass = (GymPass)session.get(GymPass.class, id);
        session.flush();
        return gymPass;
    }

    /**
     * Retrieve all gym passes from database
     * @return list of gym passes
     */
    public List<GymPass> getGymPassList() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from GymPass");
        List<GymPass> gymPasses = query.list();
        session.flush();
        return gymPasses;
    }

    /**
     * Delete existed gym pass from database.
     * @param gymPass existed pass
     */
    public void deleteGymPass(GymPass gymPass) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(gymPass);
        session.flush();
    }
}
