package com.egym.contoller.client;

import com.egym.model.*;
import com.egym.service.ClientService;
import com.egym.service.TrainerService;
import com.egym.service.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 * Created by MichaelMAC on 12.01.17.
 */
@Controller
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private TrainerService trainerService;

    @Autowired
    private WorkoutService workoutService;


    /**
     * Request mapping method for client pass info method. If client bought a gym pass the appropriate text is shown.
     * @param paymentSuccess Not null if client bought a gym pass
     */
    @RequestMapping("/clientPassInfo")
    public String clientPassInfo(@RequestParam(value = "paymentSuccess", required = false) String paymentSuccess,
                                 Model model, @AuthenticationPrincipal User activeUser){
        if(paymentSuccess != null){
            model.addAttribute("paymentSuccess", "You have bought gym pass successfully!");
        }
        Client client = clientService.getClientByUsername(activeUser.getUsername());
        model.addAttribute("client", client);
        return "clientPassInfo";
    }

    /**
     * Request mapping method from client personal card. If client saved info the appropriate text is shown.
     * @param savedSuccessful Not null if client saved info
     */
    @RequestMapping("/clientPersonalCard")
    public String clientPersonalCard(@RequestParam(value = "savedSuccessful", required = false) String savedSuccessful,
            Model model, @AuthenticationPrincipal User activeUser) {

        if(savedSuccessful != null){
            model.addAttribute("savedSuccessful", "Your information saved successful!");
        }

        Client client = clientService.getClientByUsername(activeUser.getUsername());
        model.addAttribute("clientCard", client.getClientCard());

        return "clientPersonalCard";

    }

    /**
     * POST method for saving client personal card info. Info is saved into database.
     * @param card ClientPersonalCard from spring model
     * @param result binding result from validation
     */
    @RequestMapping(value = "/clientPersonalCard", method = RequestMethod.POST)
    public String editGymPass(@Valid @ModelAttribute("card") ClientPersonalCard card, BindingResult result, Model model,
                              @AuthenticationPrincipal User activeUser){
        if (result.hasErrors()){
            return "clientPersonalCard";
        }
        Client client = clientService.getClientByUsername(activeUser.getUsername());
        client.setClientCard(card);
        clientService.editClient(client);
        return "redirect:/client/clientPersonalCard?savedSuccessful";
    }

    /**
     * Request mapping page for star training. Checks whether client info is filled and trainer is chosen. If not,
     * the appropriate text is shown. If client already waiting for training, the appropriate text is shown.
     * Workout object is added to spring model if everything is fine.
     */
    @RequestMapping("/startTraining")
    public String startTraining(Model model, @AuthenticationPrincipal User activeUser){

        Client client = clientService.getClientByUsername(activeUser.getUsername());
        ClientPersonalCard emptyCard = new ClientPersonalCard(0,0,0,0,0,0,0);
        if(client.getClientCard().equals(emptyCard) || client.getTrainer() == null) {
            model.addAttribute("cantStart", "You have to fill your personal card and choose your trainer before start");
            return "startTraining";
        }
        Workout lastWorkout = workoutService.getLatestWorkoutByClient(client);
        if(lastWorkout != null)
            if(!lastWorkout.getWorkoutDate().isBefore(LocalDate.now())) {
                model.addAttribute("workoutIsSet", "You have already choose the time for workout! Wait until trainer will make training for you!");
                model.addAttribute("workout", lastWorkout);
                List<ExerciseItem> exerciseItems = lastWorkout.getExerciseItems();
                model.addAttribute("exerciseItems", exerciseItems);
                return "startTraining";
            }

        Workout workout = new Workout();
        workout.setWorkoutDate(LocalDate.now());
        workout.setWorkoutTime(LocalTime.now());
        workout.setClient(client);
        workout.setTrainer(client.getTrainer());
        model.addAttribute("workout", workout);
        return "startTraining";
    }

    /**
     * POST method for start training. Saves data of workout into database. Also refreshes client need to create workout field in database.
     * @param workout Workout from spring model
     * @param result binding result from validation
     */
    @RequestMapping(value = "/startTraining", method = RequestMethod.POST)
    public String startTraining(@ModelAttribute("workout")Workout workout, BindingResult result, @AuthenticationPrincipal User activeUser, Model model){
        if (result.hasErrors()){
            return "startTraining";
        }
        Client client = clientService.getClientByUsername(activeUser.getUsername());
        client.setNeedToCreateWorkout(true);

        clientService.editClient(client);
        workout.setClient(client);
        workout.setTrainer(client.getTrainer());
        workoutService.addWorkout(workout);
        return "redirect:/client/startTraining";
    }


}
