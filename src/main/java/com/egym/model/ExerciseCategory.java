package com.egym.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by MichaelMAC on 14.01.17.
 */
@Entity
public class ExerciseCategory implements Serializable {


    private static final long serialVersionUID = 4952771729784252812L;

    @Id
    @GeneratedValue
    private int categoryId;

    private String name;

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
