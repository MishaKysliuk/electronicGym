package com.egym.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.io.Serializable;

/**
 * Created by MichaelMAC on 10.01.17.
 */
@Entity
public class Payment implements Serializable {

    private static final long serialVersionUID = -2250000089086154262L;

    @Id
    @GeneratedValue
    private int paymentId;
    private String cardNumber;
    private String cardOwnerName;
    private String cardOwnerSurname;
    private String expirationDate;
    private String cvvCode;




    /*@OneToOne
    private Client client;*/

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardOwnerName() {
        return cardOwnerName;
    }

    public void setCardOwnerName(String cardOwnerName) {
        this.cardOwnerName = cardOwnerName;
    }

    public String getCardOwnerSurname() {
        return cardOwnerSurname;
    }

    public void setCardOwnerSurname(String cardOwnerSurname) {
        this.cardOwnerSurname = cardOwnerSurname;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getCvvCode() {
        return cvvCode;
    }

    public void setCvvCode(String cvvCode) {
        this.cvvCode = cvvCode;
    }


    @Override
    public String toString() {
        return "Payment{" +
                "paymentId=" + paymentId +
                ", cardNumber='" + cardNumber + '\'' +
                ", cardOwnerName='" + cardOwnerName + '\'' +
                ", cardOwnerSurname='" + cardOwnerSurname + '\'' +
                ", expirationDate='" + expirationDate + '\'' +
                ", cvvCode='" + cvvCode + '\'' +
                '}';
    }
}
