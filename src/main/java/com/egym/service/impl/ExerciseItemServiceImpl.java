package com.egym.service.impl;

import com.egym.dao.ExerciseItemDao;
import com.egym.model.ExerciseItem;
import com.egym.service.ExerciseItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by MichaelMAC on 15.01.17.
 */
@Service
public class ExerciseItemServiceImpl implements ExerciseItemService{

    @Autowired
    private ExerciseItemDao exerciseItemDao;

    public void addExerciseItem(ExerciseItem exerciseItem) {
        exerciseItemDao.addExerciseItem(exerciseItem);
    }

    public List<ExerciseItem> getItemsByWorkoutId(int workoutId) {
        return exerciseItemDao.getItemsByWorkoutId(workoutId);
    }

    public void removeExerciseItem(ExerciseItem exerciseItem) {
        exerciseItemDao.removeExerciseItem(exerciseItem);
    }

    public void editExerciseItem(ExerciseItem exerciseItem) {
        exerciseItemDao.editExerciseItem(exerciseItem);
    }
}
