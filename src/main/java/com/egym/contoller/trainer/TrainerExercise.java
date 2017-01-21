package com.egym.contoller.trainer;

import com.egym.model.Exercise;
import com.egym.model.ExerciseCategory;
import com.egym.model.GymPass;
import com.egym.model.util.FileHelper;
import com.egym.service.ExerciseCategoryService;
import com.egym.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by MichaelMAC on 14.01.17.
 */
@Controller
@RequestMapping("/trainer/exercises")
public class TrainerExercise {

    @Autowired
    private ExerciseService exerciseService;

    @Autowired
    private ExerciseCategoryService exerciseCategoryService;

    private Path path;

    @RequestMapping("")
    public String exerciseList(Model model){
        List<ExerciseCategory> categoryList = exerciseCategoryService.getExerciseCategoryList();
        model.addAttribute("categoryList", categoryList);
        List<Exercise> exerciseList = exerciseService.getExerciseList();
        model.addAttribute("exerciseList", exerciseList);
        return "exerciseList";
    }

    @RequestMapping("/addExercise")
    public String addExercise(Model model){
        Exercise exercise = new Exercise();
        model.addAttribute("exercise", exercise);
        List<ExerciseCategory> categoryList = exerciseCategoryService.getExerciseCategoryList();
        model.addAttribute("categoryList", categoryList);

        return "addExercise";
    }

    @RequestMapping(value = "/addExercise", method = RequestMethod.POST)
    public String addExercise(@Valid @ModelAttribute("exercise") Exercise exercise, BindingResult result, HttpServletRequest request){
        if (result.hasErrors()){
            return "addExercise";
        }
        exerciseService.addExercise(exercise);

        MultipartFile exerciseImage = exercise.getExerciseImage();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "WEB-INF/resources/images/exercises/" + exercise.getExerciseId() + ".png");

        FileHelper.transferFile(exerciseImage, path);

        return "redirect:/trainer/exercises";
    }

    @RequestMapping("/editExercise/{exerciseId}")
    public String editGymPass(@PathVariable int exerciseId, Model model){
        Exercise exercise = exerciseService.getExerciseById(exerciseId);
        model.addAttribute(exercise);
        List<ExerciseCategory> categoryList = exerciseCategoryService.getExerciseCategoryList();
        model.addAttribute("categoryList", categoryList);

        return "editExercise";
    }

    @RequestMapping(value = "/editExercise/{exerciseId}", method = RequestMethod.POST)
    public String editGymPass(@Valid @ModelAttribute("exercise") Exercise exercise, BindingResult result, Model model, HttpServletRequest request){
        if (result.hasErrors()){
            return "editExercise";
        }
        MultipartFile exerciseImage = exercise.getExerciseImage();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "WEB-INF/resources/images/exercises/" + exercise.getExerciseId() + ".png");
        FileHelper.transferFile(exerciseImage, path);
        exerciseService.editExercise(exercise);
        return "redirect:/trainer/exercises";
    }

    @RequestMapping("/deleteExercise/{exerciseId}")
    public String deleteGymPass(@PathVariable int exerciseId, Model model, HttpServletRequest request){
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "WEB-INF/resources/images/exercises/" + exerciseId + ".png");
        if(Files.exists(path)){
            try {
                Files.delete(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Exercise exercise = exerciseService.getExerciseById(exerciseId);
        exerciseService.deleteExercise(exercise);

        return "redirect:/trainer/exercises";
    }
}
