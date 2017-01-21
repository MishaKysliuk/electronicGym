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

    public void addExercise(Exercise exercise) {
        exerciseDao.addExercise(exercise);
    }

    public void editExercise(Exercise exercise) {
        exerciseDao.editExercise(exercise);
    }

    public Exercise getExerciseById(int id) {
        return exerciseDao.getExerciseById(id);
    }

    public List<Exercise> getExerciseList() {
        return exerciseDao.getExerciseList();
    }

    public void deleteExercise(Exercise exercise) {
        exerciseDao.deleteExercise(exercise);
    }
}
