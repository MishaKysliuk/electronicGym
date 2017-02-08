package com.egym.service.impl;

import com.egym.dao.ExerciseDao;
import com.egym.model.Exercise;
import com.egym.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by MichaelMAC on 14.01.17.
 */
@Service
public class ExerciseServiceImpl implements ExerciseService{

    @Autowired
    private ExerciseDao exerciseDao;

    /**
     * Add new exercise to database.
     * @param exercise new exercise
     */
    public void addExercise(Exercise exercise) {
        exerciseDao.addExercise(exercise);
    }

    /**
     * Edit existed exercise in database.
     * @param exercise existed exercise
     */
    public void editExercise(Exercise exercise) {
        exerciseDao.editExercise(exercise);
    }

    /**
     * Retrieve exercise from database by its id.
     * @param id id of exercise
     * @return appropriate exercise
     */
    public Exercise getExerciseById(int id) {
        return exerciseDao.getExerciseById(id);
    }

    /**
     * Retrieve all exercises from database
     * @return exercises list
     */
    public List<Exercise> getExerciseList() {
        return exerciseDao.getExerciseList();
    }

    /**
     * Delete exercise from database
     * @param exercise exercise to be deleted
     */
    public void deleteExercise(Exercise exercise) {
        exerciseDao.deleteExercise(exercise);
    }
}
