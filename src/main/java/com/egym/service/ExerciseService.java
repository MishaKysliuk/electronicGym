package com.egym.service;

import com.egym.model.Exercise;

import java.util.List;

/**
 * Created by MichaelMAC on 14.01.17.
 */
public interface ExerciseService {

    void addExercise(Exercise exercise);

    void editExercise(Exercise exercise);

    Exercise getExerciseById(int id);

    List<Exercise> getExerciseList();

    void deleteExercise(Exercise exercise);

}
