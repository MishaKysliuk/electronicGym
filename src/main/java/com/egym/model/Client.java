package com.egym.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by MichaelMAC on 10.01.17.
 */
@Entity
public class Client implements Serializable {

    private static final long serialVersionUID = -6527209438383800876L;

    @Id
    @GeneratedValue
    private int clientId;

    @NotEmpty(message = "The customer name must not be null.")
    private String clientName;

    @NotEmpty (message = "The customer email must not be null.")
    private String clientEmail;
    private String clientPhone;

    @NotEmpty (message = "The customer username must not be null.")
    private String username;

    @NotEmpty (message = "The customer password must not be null.")
    private String password;

    private boolean enabled;

    @ManyToOne
    @JoinColumn(name = "trainerId")
    @JsonIgnore
    private Trainer trainer;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Workout> workouts;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "orderId")
    private PassOrder passOrder;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cardId")
    private ClientPersonalCard clientCard;

    private LocalDate gymPassExpirationDate;

    private boolean needToCreateWorkout;


    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public String getClientPhone() {
        return clientPhone;
    }

    public void setClientPhone(String clientPhone) {
        this.clientPhone = clientPhone;
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

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public List<Workout> getWorkouts() {
        return workouts;
    }

    public void setWorkouts(List<Workout> workouts) {
        this.workouts = workouts;
    }

    public PassOrder getPassOrder() {
        return passOrder;
    }

    public void setPassOrder(PassOrder passOrder) {
        this.passOrder = passOrder;
    }

    public LocalDate getGymPassExpirationDate() {
        return gymPassExpirationDate;
    }

    public ClientPersonalCard getClientCard() {
        return clientCard;
    }

    public void setClientCard(ClientPersonalCard clientCard) {
        this.clientCard = clientCard;
    }

    public void setGymPassExpirationDate(LocalDate gymPassExpirationDate) {
        this.gymPassExpirationDate = gymPassExpirationDate;
    }

    public boolean isNeedToCreateWorkout() {
        return needToCreateWorkout;
    }

    public void setNeedToCreateWorkout(boolean needToCreateWorkout) {
        this.needToCreateWorkout = needToCreateWorkout;
    }
}
