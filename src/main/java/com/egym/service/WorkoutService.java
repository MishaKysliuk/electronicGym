package com.egym.service;

import com.egym.model.Client;
import com.egym.model.Workout;

import java.util.List;

/**
 * Created by MichaelMAC on 15.01.17.
 */
public interface WorkoutService {

    void addWorkout(Workout workout);

    void editWorkout(Workout workout);

    List<Workout> getWorkoutsByClient(Client client);

    Workout getLatestWorkoutByClient(Client client);

}
