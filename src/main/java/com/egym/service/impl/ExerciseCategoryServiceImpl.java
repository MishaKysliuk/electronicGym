package com.egym.service.impl;

import com.egym.dao.ExerciseCategoryDao;
import com.egym.model.ExerciseCategory;
import com.egym.service.ExerciseCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by MichaelMAC on 14.01.17.
 */
@Service
public class ExerciseCategoryServiceImpl implements ExerciseCategoryService{

    @Autowired
    private ExerciseCategoryDao exerciseCategoryDao;

    /**
     * Add new category to database.
     * @param category new category
     */
    public void addCategory(ExerciseCategory category) {
        exerciseCategoryDao.addCategory(category);
    }

    /**
     * Retrieve all exercise categories from database.
     * @return categories list
     */
    public List<ExerciseCategory> getExerciseCategoryList() {
        return exerciseCategoryDao.getExerciseCategoryList();
    }

    /**
     * Retrieve exercise category by its id from database.
     * @param id id of exercise category
     * @return appropriate category
     */
    public ExerciseCategory getExerciseCategoryById(int id) {
        return exerciseCategoryDao.getExerciseCategoryById(id);
    }
}
