package com.egym.dao.impl;

import com.egym.dao.ExerciseDao;
import com.egym.model.Exercise;
import com.egym.model.GymPass;
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
public class ExerciseDaoImpl implements ExerciseDao{

    @Autowired
    private SessionFactory sessionFactory;

    /**
     * Add new exercise to database.
     * @param exercise new exercise
     */
    public void addExercise(Exercise exercise) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(exercise);
        session.flush();
    }

    /**
     * Edit existed exercise in database.
     * @param exercise existed exercise
     */
    public void editExercise(Exercise exercise) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(exercise);
        session.flush();
    }

    /**
     * Retrieve exercise from database by its id.
     * @param id id of exercise
     * @return appropriate exercise
     */
    public Exercise getExerciseById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Exercise exercise = (Exercise)session.get(Exercise.class, id);
        session.flush();
        return exercise;
    }

    /**
     * Retrieve all exercises from database
     * @return exercises list
     */
    public List<Exercise> getExerciseList() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Exercise");
        List<Exercise> exercises = query.list();
        session.flush();
        return exercises;
    }

    /**
     * Delete exercise from database
     * @param exercise exercise to be deleted
     */
    public void deleteExercise(Exercise exercise) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(exercise);
        session.flush();
    }
}
