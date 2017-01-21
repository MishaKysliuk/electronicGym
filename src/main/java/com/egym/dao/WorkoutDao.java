package com.egym.dao;

import com.egym.model.Client;
import com.egym.model.Trainer;
import com.egym.model.Workout;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by MichaelMAC on 15.01.17.
 */
public interface WorkoutDao {

    void addWorkout(Workout workout);

    void editWorkout(Workout workout);

    List<Workout> getWorkoutsByClient(Client client);

    Workout getLatestWorkoutByClient(Client client);

}
