package com.egym.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * Created by MichaelMAC on 05.01.17.
 */
@Entity
public class GymPass implements Serializable {


    private static final long serialVersionUID = 8477204701647324446L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int passId;
    @NotEmpty(message = "The name must not be empty")
    private String passName;
    private String passCategory;
    @Min(value = 1, message = "Duration must be above zero")
    private int passDurationInMonths;
    @Min(value = 0, message = "Price must not be less than zero")
    private double passPrice;
    private String passDescription;

    @Transient
    private MultipartFile gymPassImage;

    public int getPassId() {
        return passId;
    }

    public void setPassId(int passId) {
        this.passId = passId;
    }

    public String getPassName() {
        return passName;
    }

    public void setPassName(String passName) {
        this.passName = passName;
    }

    public String getPassCategory() {
        return passCategory;
    }

    public void setPassCategory(String passCategory) {
        this.passCategory = passCategory;
    }

    public int getPassDurationInMonths() {
        return passDurationInMonths;
    }

    public void setPassDurationInMonths(int passDurationInMonths) {
        this.passDurationInMonths = passDurationInMonths;
    }

    public double getPassPrice() {
        return passPrice;
    }

    public void setPassPrice(double passPrice) {
        this.passPrice = passPrice;
    }

    public String getPassDescription() {
        return passDescription;
    }

    public void setPassDescription(String passDescription) {
        this.passDescription = passDescription;
    }

    public MultipartFile getGymPassImage() {
        return gymPassImage;
    }

    public void setGymPassImage(MultipartFile gymPassImage) {
        this.gymPassImage = gymPassImage;
    }


    @Override
    public String toString() {
        return "GymPass{" +
                "passId=" + passId +
                ", passName='" + passName + '\'' +
                ", passCategory='" + passCategory + '\'' +
                ", passDurationInMonths=" + passDurationInMonths +
                ", passPrice=" + passPrice +
                ", passDescription='" + passDescription + '\'' +
                ", gymPassImage=" + gymPassImage +
                '}';
    }
}
