package com.egym.dao.impl;

import com.egym.dao.WorkoutDao;
import com.egym.model.Client;
import com.egym.model.GymPass;
import com.egym.model.Workout;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by MichaelMAC on 15.01.17.
 */
@Repository
@Transactional
public class WorkoutDaoImpl implements WorkoutDao{

    @Autowired
    private SessionFactory sessionFactory;

    /**
     * Add new workout to database.
     * @param workout new workout
     */
    public void addWorkout(Workout workout) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(workout);
        session.flush();
    }

    /**
     * Edit existed workout into database
     * @param workout existed workout
     */
    public void editWorkout(Workout workout) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(workout);
        session.flush();
    }

    /**
     * Retrieve workouts from database by certain client
     * @param client certain client
     * @return list of workouts
     */
    public List<Workout> getWorkoutsByClient(Client client) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Workout where clientId = ?");
        query.setInteger(0, client.getClientId());
        List<Workout> workouts = query.list();
        session.flush();
        return workouts;
    }

    /**
     * Retrieve last workout by date of certain client from database
     * @param client certain client
     * @return last workout or null if client has no workouts
     */
    public Workout getLatestWorkoutByClient(Client client) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Workout where clientId = ? ORDER BY workoutDate DESC");
        query.setInteger(0, client.getClientId());
        List<Workout> workouts = query.list();
        session.flush();
        if(workouts.size() != 0)
            return workouts.get(0);
        else
            return null;
    }
}
