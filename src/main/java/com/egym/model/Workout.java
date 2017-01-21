package com.egym.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 * Created by MichaelMAC on 10.01.17.
 */
@Entity
public class Workout implements Serializable {

    private static final long serialVersionUID = 6374057631767054311L;

    @Id
    @GeneratedValue
    private int workoutId;

    private LocalDate workoutDate;

    private LocalTime workoutTime;


    @JsonIgnore
    @OneToMany(mappedBy = "workout", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ExerciseItem> exerciseItems;

    @ManyToOne
    @JoinColumn(name = "clientId")
    @JsonIgnore
    private Client client;

    @ManyToOne
    @JoinColumn(name = "trainerId")
    @JsonIgnore
    private Trainer trainer;

    private int workoutDurationInSec;


    public int getWorkoutId() {
        return workoutId;
    }

    public void setWorkoutId(int workoutId) {
        this.workoutId = workoutId;
    }

    public LocalDate getWorkoutDate() {
        return workoutDate;
    }

    public void setWorkoutDate(LocalDate workoutDate) {
        this.workoutDate = workoutDate;
    }



    public LocalTime getWorkoutTime() {
        return workoutTime;
    }

    public void setWorkoutTime(LocalTime workoutTime) {
        this.workoutTime = workoutTime;
    }

    public List<ExerciseItem> getExerciseItems() {
        return exerciseItems;
    }

    public void setExerciseItems(List<ExerciseItem> exerciseItems) {
        this.exerciseItems = exerciseItems;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public int getWorkoutDurationInSec() {
        return workoutDurationInSec;
    }

    public void setWorkoutDurationInSec(int workoutDurationInSec) {
        this.workoutDurationInSec = workoutDurationInSec;
    }
}
