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

    public void addExercise(Exercise exercise) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(exercise);
        session.flush();
    }

    public void editExercise(Exercise exercise) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(exercise);
        session.flush();
    }

    public Exercise getExerciseById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Exercise exercise = (Exercise)session.get(Exercise.class, id);
        session.flush();
        return exercise;
    }

    public List<Exercise> getExerciseList() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Exercise");
        List<Exercise> exercises = query.list();
        session.flush();
        return exercises;
    }

    public void deleteExercise(Exercise exercise) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(exercise);
        session.flush();
    }
}
