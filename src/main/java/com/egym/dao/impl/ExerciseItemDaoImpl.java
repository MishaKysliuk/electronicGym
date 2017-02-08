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

    /**
     * Add new exercise item to database
     * @param exerciseItem new exercise item
     */
    public void addExerciseItem(ExerciseItem exerciseItem) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(exerciseItem);
        session.flush();
    }

    /**
     * Retrieve exercise items from database by workout id
     * @param workoutId workoutId of exercise items
     * @return list of exercise items
     */
    public List<ExerciseItem> getItemsByWorkoutId(int workoutId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from ExerciseItem where workoutId = ?");
        query.setInteger(0, workoutId);
        List<ExerciseItem> items = query.list();
        return items;
    }

    /**
     * Remove exercise item from database
     * @param exerciseItem item to be removed
     */
    public void removeExerciseItem(ExerciseItem exerciseItem) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(exerciseItem);
        session.flush();
    }

    /**
     * Edit existed exercise item in database
     * @param exerciseItem existed item
     */
    public void editExerciseItem(ExerciseItem exerciseItem) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(exerciseItem);
        session.flush();
    }
}
