package com.egym.dao;

import com.egym.model.Exercise;
import com.egym.model.ExerciseCategory;
import com.egym.model.GymPass;

import java.util.List;

/**
 * Created by MichaelMAC on 14.01.17.
 */
public interface ExerciseCategoryDao {

    void addCategory(ExerciseCategory category);

    List<ExerciseCategory> getExerciseCategoryList();

    ExerciseCategory getExerciseCategoryById(int id);

}
