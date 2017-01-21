package com.egym.contoller;

import com.egym.model.Exercise;
import com.egym.model.GymPass;
import com.egym.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

/**
 * Created by MichaelMAC on 15.01.17.
 */
@Controller
public class ExerciseController {

    @Autowired
    private ExerciseService exerciseService;

    @RequestMapping("/exercises/viewExercise/{exerciseId}")
    public String viewExercise(@PathVariable int exerciseId, Model model) {
        Exercise exercise = exerciseService.getExerciseById(exerciseId);
        model.addAttribute("exercise", exercise);

        return "viewExercise";
    }
}
