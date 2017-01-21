package com.egym.service;

import com.egym.model.ExerciseItem;

import java.util.List;

/**
 * Created by MichaelMAC on 15.01.17.
 */
public interface ExerciseItemService {

    void addExerciseItem(ExerciseItem exerciseItem);

    List<ExerciseItem> getItemsByWorkoutId(int workoutId);

    void removeExerciseItem(ExerciseItem exerciseItem);

    void editExerciseItem(ExerciseItem exerciseItem);

}
