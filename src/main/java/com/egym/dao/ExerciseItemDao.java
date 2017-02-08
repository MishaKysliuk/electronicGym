package com.egym.dao;

import com.egym.model.ExerciseItem;

import java.util.List;

/**
 * Created by MichaelMAC on 15.01.17.
 */
public interface ExerciseItemDao {

    /**
     * Add new exercise item to database
     * @param exerciseItem new exercise item
     */
    void addExerciseItem(ExerciseItem exerciseItem);

    /**
     * Retrieve exercise items from database by workout id
     * @param workoutId workoutId of exercise items
     * @return list of exercise items
     */
    List<ExerciseItem> getItemsByWorkoutId(int workoutId);

    /**
     * Remove exercise item from database
     * @param exerciseItem item to be removed
     */
    void removeExerciseItem(ExerciseItem exerciseItem);

    /**
     * Edit existed exercise item in database
     * @param exerciseItem existed item
     */
    void editExerciseItem(ExerciseItem exerciseItem);

}
