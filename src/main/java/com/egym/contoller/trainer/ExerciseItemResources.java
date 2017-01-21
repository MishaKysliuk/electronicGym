package com.egym.contoller.trainer;

import com.egym.model.Client;
import com.egym.model.Exercise;
import com.egym.model.ExerciseItem;
import com.egym.model.Workout;
import com.egym.service.ClientService;
import com.egym.service.ExerciseService;
import com.egym.service.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MichaelMAC on 15.01.17.
 */
@Controller
@RequestMapping("/rest/exerciseItem/")
public class ExerciseItemResources {

    @Autowired
    private ExerciseService exerciseService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private WorkoutService workoutService;

    @RequestMapping("/add/{exerciseId}")
    public @ResponseBody
    List<ExerciseItem> addItem (@PathVariable(value = "exerciseId") int exerciseId,
                                @RequestBody List<ExerciseItem> itemList,
                                @RequestParam("clientId") int clientId) {
        List<ExerciseItem> result;
        if(itemList != null)
            result = new ArrayList<ExerciseItem>(itemList);
        else
            result = new ArrayList<ExerciseItem>();
        ExerciseItem newItem = new ExerciseItem();
        newItem.setExercise(exerciseService.getExerciseById(exerciseId));
        Client client = clientService.getClientById(clientId);
        result.add(newItem);
        return result;
    }

    @RequestMapping(value = "/saveWorkout", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void saveWorkout(@RequestParam("clientId") int clientId, @RequestParam("duration") int durationInSec, @RequestBody List<ExerciseItem> itemList){

        Client client = clientService.getClientById(clientId);
        client.setNeedToCreateWorkout(false);
        clientService.editClient(client);
        Workout workout = workoutService.getLatestWorkoutByClient(client);
        for(ExerciseItem item: itemList)
            item.setWorkout(workout);
        workout.setExerciseItems(itemList);
        workout.setWorkoutDurationInSec(durationInSec);
        workoutService.editWorkout(workout);

    }

    @RequestMapping("/init")
    public @ResponseBody
    List<ExerciseItem> init () {
        return new ArrayList<ExerciseItem>();
    }

    @RequestMapping("/getExercises")
    public @ResponseBody
    List<Exercise> getExercises(){
        return exerciseService.getExerciseList();
    }
}
