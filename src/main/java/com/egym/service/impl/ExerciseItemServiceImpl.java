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

    /**
     * Add new exercise item to database
     * @param exerciseItem new exercise item
     */
    public void addExerciseItem(ExerciseItem exerciseItem) {
        exerciseItemDao.addExerciseItem(exerciseItem);
    }

    /**
     * Retrieve exercise items from database by workout id
     * @param workoutId workoutId of exercise items
     * @return list of exercise items
     */
    public List<ExerciseItem> getItemsByWorkoutId(int workoutId) {
        return exerciseItemDao.getItemsByWorkoutId(workoutId);
    }

    /**
     * Remove exercise item from database
     * @param exerciseItem item to be removed
     */
    public void removeExerciseItem(ExerciseItem exerciseItem) {
        exerciseItemDao.removeExerciseItem(exerciseItem);
    }

    /**
     * Edit existed exercise item in database
     * @param exerciseItem existed item
     */
    public void editExerciseItem(ExerciseItem exerciseItem) {
        exerciseItemDao.editExerciseItem(exerciseItem);
    }
}
