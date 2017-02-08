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

    /**
     * Add new workout to database.
     * @param workout new workout
     */
    public void addWorkout(Workout workout) {
        workoutDao.addWorkout(workout);
    }

    /**
     * Edit existed workout into database
     * @param workout existed workout
     */
    public void editWorkout(Workout workout) {
        workoutDao.editWorkout(workout);
    }

    /**
     * Retrieve workouts from database by certain client
     * @param client certain client
     * @return list of workouts
     */
    public List<Workout> getWorkoutsByClient(Client client) {
        return workoutDao.getWorkoutsByClient(client);
    }

    /**
     * Retrieve last workout by date of certain client from database
     * @param client certain client
     * @return last workout or null if client has no workouts
     */
    public Workout getLatestWorkoutByClient(Client client) {
        return workoutDao.getLatestWorkoutByClient(client);
    }
}
