package com.egym.contoller;

import com.egym.model.Client;
import com.egym.model.GymPass;
import com.egym.model.Trainer;
import com.egym.service.ClientService;
import com.egym.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by MichaelMAC on 14.01.17.
 */
@Controller
public class TrainerListController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private TrainerService trainerService;

    @RequestMapping("/trainers")
    public String clientTrainer(Model model, @AuthenticationPrincipal User activeUser){

        List<Trainer> trainerList = trainerService.getAllTrainers();
        model.addAttribute("trainerList", trainerList);

        if(activeUser == null)
            return "trainers";

        Client client = clientService.getClientByUsername(activeUser.getUsername());

        if(client == null)
            return "trainers";

        if(client.getGymPassExpirationDate() == null || client.getGymPassExpirationDate().isBefore(LocalDate.now()))
            model.addAttribute("invalidGymPass", "You have to buy gym pass before choosing trainer!");
        if(client.getTrainer() != null)
            model.addAttribute("clientTrainer", client.getTrainer());

        return "trainers";
    }

    @RequestMapping("/trainers/viewTrainer/{trainerId}")
    public String viewTrainer(@PathVariable int trainerId, Model model) {
        Trainer trainer = trainerService.getTrainerById(trainerId);
        model.addAttribute("trainer", trainer);

        return "viewTrainer";
    }

    @RequestMapping("/trainers/{trainerId}")
    public String chooseTrainer(@PathVariable int trainerId, Model model, @AuthenticationPrincipal User activeUser) {

        Client client = clientService.getClientByUsername(activeUser.getUsername());
        Trainer trainer = trainerService.getTrainerById(trainerId);

        client.setTrainer(trainer);
        clientService.editClient(client);


        return "redirect:/trainers";
    }
}
