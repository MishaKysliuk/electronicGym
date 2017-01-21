package com.egym.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * Created by MichaelMAC on 10.01.17.
 */
@Entity
public class PassOrder implements Serializable {

    private static final long serialVersionUID = 2740278102588794693L;

    @Id
    @GeneratedValue
    private int orderId;

    @ManyToOne
    @JoinColumn(name = "passId")
    @JsonIgnore
    private GymPass gymPass;

    private LocalDate date;

    @OneToOne()
    @JoinColumn(name = "clientId")
    private Client client;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="paymentId")
    private Payment payment;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public GymPass getGymPass() {
        return gymPass;
    }

    public void setGymPass(GymPass gymPass) {
        this.gymPass = gymPass;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
