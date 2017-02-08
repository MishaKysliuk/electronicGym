package com.egym.service;

import com.egym.model.ExerciseCategory;

import java.util.List;

/**
 * Created by MichaelMAC on 14.01.17.
 */
public interface ExerciseCategoryService {

    /**
     * Add new category to database.
     * @param category new category
     */
    void addCategory(ExerciseCategory category);

    /**
     * Retrieve all exercise categories from database.
     * @return categories list
     */
    List<ExerciseCategory> getExerciseCategoryList();

    /**
     * Retrieve exercise category by its id from database.
     * @param id id of exercise category
     * @return appropriate category
     */
    ExerciseCategory getExerciseCategoryById(int id);
}
