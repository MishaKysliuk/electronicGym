package com.egym.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by MichaelMAC on 10.01.17.
 */
@Entity
public class Exercise implements Serializable {

    private static final long serialVersionUID = 3180717148722535222L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int exerciseId;
    @NotEmpty(message = "The name must not be empty")
    private String exerciseName;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    @JsonIgnore
    private ExerciseCategory exerciseCategory;

    private String exerciseDescription;

    private int avgSecondsForRep;
    private int avgSecondsBetweenSets;

    @Transient
    @JsonIgnore
    private MultipartFile exerciseImage;


    public int getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(int exerciseId) {
        this.exerciseId = exerciseId;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public ExerciseCategory getExerciseCategory() {
        return exerciseCategory;
    }

    public void setExerciseCategory(ExerciseCategory exerciseCategory) {
        this.exerciseCategory = exerciseCategory;
    }

    public String getExerciseDescription() {
        return exerciseDescription;
    }

    public void setExerciseDescription(String exerciseDescription) {
        this.exerciseDescription = exerciseDescription;
    }

    public MultipartFile getExerciseImage() {
        return exerciseImage;
    }

    public void setExerciseImage(MultipartFile exerciseImage) {
        this.exerciseImage = exerciseImage;
    }

    public int getAvgSecondsForRep() {
        return avgSecondsForRep;
    }

    public void setAvgSecondsForRep(int avgSecondsForRep) {
        this.avgSecondsForRep = avgSecondsForRep;
    }

    public int getAvgSecondsBetweenSets() {
        return avgSecondsBetweenSets;
    }

    public void setAvgSecondsBetweenSets(int avgSecondsBetweenSets) {
        this.avgSecondsBetweenSets = avgSecondsBetweenSets;
    }
}
