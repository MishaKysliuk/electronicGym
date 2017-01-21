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

    public void addCategory(ExerciseCategory category) {
        exerciseCategoryDao.addCategory(category);
    }

    public List<ExerciseCategory> getExerciseCategoryList() {
        return exerciseCategoryDao.getExerciseCategoryList();
    }

    public ExerciseCategory getExerciseCategoryById(int id) {
        return exerciseCategoryDao.getExerciseCategoryById(id);
    }
}
