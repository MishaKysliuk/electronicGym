package com.egym.service;

import com.egym.model.Exercise;

import java.util.List;

/**
 * Created by MichaelMAC on 14.01.17.
 */
public interface ExerciseService {

    /**
     * Add new exercise to database.
     * @param exercise new exercise
     */
    void addExercise(Exercise exercise);

    /**
     * Edit existed exercise in database.
     * @param exercise existed exercise
     */
    void editExercise(Exercise exercise);


    /**
     * Retrieve exercise from database by its id.
     * @param id id of exercise
     * @return appropriate exercise
     */
    Exercise getExerciseById(int id);

    /**
     * Retrieve all exercises from database
     * @return exercises list
     */
    List<Exercise> getExerciseList();

    /**
     * Delete exercise from database
     * @param exercise exercise to be deleted
     */
    void deleteExercise(Exercise exercise);

}
