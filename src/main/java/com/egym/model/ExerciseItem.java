package com.egym.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by MichaelMAC on 10.01.17.
 */
@Entity
public class ExerciseItem implements Serializable {

    private static final long serialVersionUID = -2726790685555743939L;

    @Id
    @GeneratedValue
    private int exerciseItemId;

    @ManyToOne
    @JoinColumn(name = "workoutId")
    private Workout workout;

    @ManyToOne
    @JoinColumn(name = "exerciseId")
    private Exercise exercise;

    private int sets;
    private int reps;
    private int weight;

    public int getExerciseItemId() {
        return exerciseItemId;
    }

    public void setExerciseItemId(int exerciseItemId) {
        this.exerciseItemId = exerciseItemId;
    }

    public Workout getWorkout() {
        return workout;
    }

    public void setWorkout(Workout workout) {
        this.workout = workout;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "ExerciseItem{" +
                "exerciseItemId=" + exerciseItemId +
                ", workout=" + workout +
                ", exercise=" + exercise +
                ", sets=" + sets +
                ", reps=" + reps +
                ", weight=" + weight +
                '}';
    }
}
