package com.egym.model.converters;

import com.egym.model.ExerciseCategory;
import com.egym.service.ExerciseCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

/**
 * Created by MichaelMAC on 15.01.17.
 */
public class StringToExerciseCategory implements Converter<String, ExerciseCategory> {

    @Autowired
    private ExerciseCategoryService exerciseCategoryService;

    public ExerciseCategory convert(String s) {
        return exerciseCategoryService.getExerciseCategoryById(Integer.parseInt(s));
    }
}
