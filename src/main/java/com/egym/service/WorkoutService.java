package com.egym.service;

import com.egym.model.Client;
import com.egym.model.Workout;

import java.util.List;

/**
 * Created by MichaelMAC on 15.01.17.
 */
public interface WorkoutService {

    /**
     * Add new workout to database.
     * @param workout new workout
     */
    void addWorkout(Workout workout);

    /**
     * Edit existed workout into database
     * @param workout existed workout
     */
    void editWorkout(Workout workout);

    /**
     * Retrieve workouts from database by certain client
     * @param client certain client
     * @return list of workouts
     */
    List<Workout> getWorkoutsByClient(Client client);

    /**
     * Retrieve last workout by date of certain client from database
     * @param client certain client
     * @return last workout or null if client has no workouts
     */
    Workout getLatestWorkoutByClient(Client client);

}
