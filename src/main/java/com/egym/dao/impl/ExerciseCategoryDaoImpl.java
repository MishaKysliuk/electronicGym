package com.egym.dao.impl;

import com.egym.dao.ExerciseCategoryDao;
import com.egym.model.Exercise;
import com.egym.model.ExerciseCategory;
import com.egym.model.GymPass;
import com.egym.model.Payment;
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
public class ExerciseCategoryDaoImpl implements ExerciseCategoryDao {

    @Autowired
    private SessionFactory sessionFactory;

    /**
     * Add new category to database.
     * @param category new category
     */
    public void addCategory(ExerciseCategory category) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(category);
        session.flush();
    }

    /**
     * Retrieve all exercise categories from database.
     * @return categories list
     */
    public List<ExerciseCategory> getExerciseCategoryList() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from ExerciseCategory");
        List<ExerciseCategory> exerciseCategories = query.list();
        session.flush();
        return exerciseCategories;
    }

    /**
     * Retrieve exercise category by its id from database.
     * @param id id of exercise category
     * @return appropriate category
     */
    public ExerciseCategory getExerciseCategoryById(int id) {
        Session session = sessionFactory.getCurrentSession();
        ExerciseCategory exerciseCategory = (ExerciseCategory)session.get(ExerciseCategory.class, id);
        session.flush();
        return exerciseCategory;
    }
}
