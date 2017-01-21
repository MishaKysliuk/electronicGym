package com.egym.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by MichaelMAC on 11.01.17.
 */
@Entity
public class Trainer implements Serializable {

    private static final long serialVersionUID = 4126552818328196813L;

    @Id
    @GeneratedValue
    private int trainerId;

    @NotEmpty(message = "The trainer name must not be null.")
    private String trainerName;

    @NotEmpty (message = "The trainer email must not be null.")
    private String trainerEmail;
    private String trainerPhone;

    @NotEmpty (message = "The trainer username must not be null.")
    private String username;

    @NotEmpty (message = "The trainer password must not be null.")
    private String password;

    private boolean enabled;

    @OneToMany(mappedBy = "trainer", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Client> clients;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "trainer", cascade = CascadeType.PERSIST)
    @JsonIgnore
    private List<Workout> workouts;

    private String trainerPersonalInfo;
    @Transient
    private MultipartFile trainerPhoto;

    public int getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(int trainerId) {
        this.trainerId = trainerId;
    }

    public String getTrainerName() {
        return trainerName;
    }

    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }

    public String getTrainerEmail() {
        return trainerEmail;
    }

    public void setTrainerEmail(String trainerEmail) {
        this.trainerEmail = trainerEmail;
    }

    public String getTrainerPhone() {
        return trainerPhone;
    }

    public void setTrainerPhone(String trainerPhone) {
        this.trainerPhone = trainerPhone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public String getTrainerPersonalInfo() {
        return trainerPersonalInfo;
    }

    public void setTrainerPersonalInfo(String trainerPersonalInfo) {
        this.trainerPersonalInfo = trainerPersonalInfo;
    }

    public MultipartFile getTrainerPhoto() {
        return trainerPhoto;
    }

    public void setTrainerPhoto(MultipartFile trainerPhoto) {
        this.trainerPhoto = trainerPhoto;
    }

    public List<Workout> getWorkouts() {
        return workouts;
    }

    public void setWorkouts(List<Workout> workouts) {
        this.workouts = workouts;
    }
}
