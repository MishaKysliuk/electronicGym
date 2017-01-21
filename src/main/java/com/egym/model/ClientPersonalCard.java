package com.egym.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by MichaelMAC on 14.01.17.
 */
@Entity
public class ClientPersonalCard implements Serializable{


    private static final long serialVersionUID = -7998219100114218063L;

    @Id
    @GeneratedValue
    private int cardId;

    private double weight;

    private double height;

    private double fatPercent;

    private double waist;

    private double breastVolume;

    private double bicepsVolume;

    private double legVolume;

    public ClientPersonalCard() {
    }

    public ClientPersonalCard(double weight, double height, double fatPercent, double waist, double breastVolume, double bicepsVolume, double legVolume) {
        this.weight = weight;
        this.height = height;
        this.fatPercent = fatPercent;
        this.waist = waist;
        this.breastVolume = breastVolume;
        this.bicepsVolume = bicepsVolume;
        this.legVolume = legVolume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientPersonalCard that = (ClientPersonalCard) o;

        if (Double.compare(that.weight, weight) != 0) return false;
        if (Double.compare(that.height, height) != 0) return false;
        if (Double.compare(that.fatPercent, fatPercent) != 0) return false;
        if (Double.compare(that.waist, waist) != 0) return false;
        if (Double.compare(that.breastVolume, breastVolume) != 0) return false;
        if (Double.compare(that.bicepsVolume, bicepsVolume) != 0) return false;
        return Double.compare(that.legVolume, legVolume) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(weight);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(height);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(fatPercent);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(waist);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(breastVolume);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(bicepsVolume);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(legVolume);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getFatPercent() {
        return fatPercent;
    }

    public void setFatPercent(double fatPercent) {
        this.fatPercent = fatPercent;
    }

    public double getWaist() {
        return waist;
    }

    public void setWaist(double waist) {
        this.waist = waist;
    }

    public double getBreastVolume() {
        return breastVolume;
    }

    public void setBreastVolume(double breastVolume) {
        this.breastVolume = breastVolume;
    }

    public double getBicepsVolume() {
        return bicepsVolume;
    }

    public void setBicepsVolume(double bicepsVolume) {
        this.bicepsVolume = bicepsVolume;
    }

    public double getLegVolume() {
        return legVolume;
    }

    public void setLegVolume(double legVolume) {
        this.legVolume = legVolume;
    }
}
