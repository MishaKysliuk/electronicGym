package com.egym.service;

import com.egym.model.ExerciseCategory;

import java.util.List;

/**
 * Created by MichaelMAC on 14.01.17.
 */
public interface ExerciseCategoryService {

    void addCategory(ExerciseCategory category);

    List<ExerciseCategory> getExerciseCategoryList();

    ExerciseCategory getExerciseCategoryById(int id);

}
