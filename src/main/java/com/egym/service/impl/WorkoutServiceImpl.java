package com.egym.service.impl;

import com.egym.dao.WorkoutDao;
import com.egym.model.Client;
import com.egym.model.Workout;
import com.egym.service.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by MichaelMAC on 15.01.17.
 */
@Service
public class WorkoutServiceImpl implements WorkoutService{

    @Autowired
    private WorkoutDao workoutDao;

    public void addWorkout(Workout workout) {
        workoutDao.addWorkout(workout);
    }

    public void editWorkout(Workout workout) {
        workoutDao.editWorkout(workout);
    }

    public List<Workout> getWorkoutsByClient(Client client) {
        return workoutDao.getWorkoutsByClient(client);
    }

    public Workout getLatestWorkoutByClient(Client client) {
        return workoutDao.getLatestWorkoutByClient(client);
    }
}
