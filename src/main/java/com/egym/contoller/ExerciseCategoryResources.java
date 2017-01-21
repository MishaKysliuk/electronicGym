package com.egym.contoller;

import com.egym.model.ExerciseCategory;
import com.egym.service.ExerciseCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by MichaelMAC on 14.01.17.
 */
@Controller
@RequestMapping("/rest/category")
public class ExerciseCategoryResources {

    @Autowired
    private ExerciseCategoryService exerciseCategoryService;


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public @ResponseBody List<ExerciseCategory> addCategory (@RequestParam("categoryName") String categoryName, Model model) {
        ExerciseCategory exerciseCategory = new ExerciseCategory();
        exerciseCategory.setName(categoryName);
        exerciseCategoryService.addCategory(exerciseCategory);
        List<ExerciseCategory> categoryList = exerciseCategoryService.getExerciseCategoryList();
        return categoryList;
    }

    @RequestMapping(value = "/init", method = RequestMethod.GET)
    public @ResponseBody List<ExerciseCategory> initCategories () {
        return exerciseCategoryService.getExerciseCategoryList();
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Illegal request, please verify your payload.")
    public void handleClientErrors (Exception e) {}

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Internal Server Error.")
    public void handleServerErrors (Exception e) {}
}
