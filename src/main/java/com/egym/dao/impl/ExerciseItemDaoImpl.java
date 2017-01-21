package com.egym.dao.impl;

import com.egym.dao.ExerciseItemDao;
import com.egym.model.ExerciseItem;
import com.egym.model.Trainer;
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
public class ExerciseItemDaoImpl implements ExerciseItemDao{

    @Autowired
    private SessionFactory sessionFactory;

    public void addExerciseItem(ExerciseItem exerciseItem) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(exerciseItem);
        session.flush();
    }

    public List<ExerciseItem> getItemsByWorkoutId(int workoutId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from ExerciseItem where workoutId = ?");
        query.setInteger(0, workoutId);
        List<ExerciseItem> items = query.list();
        return items;
    }

    public void removeExerciseItem(ExerciseItem exerciseItem) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(exerciseItem);
        session.flush();
    }

    public void editExerciseItem(ExerciseItem exerciseItem) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(exerciseItem);
        session.flush();
    }
}
