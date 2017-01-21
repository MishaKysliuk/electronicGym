package com.egym.contoller.trainer;

import com.egym.model.*;
import com.egym.model.util.FileHelper;
import com.egym.service.ClientService;
import com.egym.service.ExerciseService;
import com.egym.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by MichaelMAC on 14.01.17.
 */
@Controller
@RequestMapping("/trainer")
public class TrainerController {

    @Autowired
    private TrainerService trainerService;

    @Autowired
    private ExerciseService exerciseService;

    @Autowired
    private ClientService clientService;

    private Path path;

    @RequestMapping("/trainerPersonalInfo")
    public String editGymPass(@RequestParam(value = "savedSuccessful", required = false) String savedSuccessful,
                              Model model, @AuthenticationPrincipal User activeUser){

        if(savedSuccessful != null){
            model.addAttribute("savedSuccessful", "Your information saved successful!");
        }

        Trainer trainer = trainerService.getTrainerByUsername(activeUser.getUsername());
        model.addAttribute("trainer", trainer);

        return "trainerPersonalInfo";
    }

    @RequestMapping(value = "/trainerPersonalInfo", method = RequestMethod.POST)
    public String editGymPass(@Valid @ModelAttribute("trainer") Trainer trainer, BindingResult result, Model model,
                              @AuthenticationPrincipal User activeUser, HttpServletRequest request){
        if (result.hasErrors()){
            System.out.println("Hello");
            return "trainerPersonalInfo";
        }
        MultipartFile trainerPhoto = trainer.getTrainerPhoto();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "WEB-INF/resources/images/trainers/" + trainer.getTrainerId() + ".png");
        System.out.println(path.toString());
        FileHelper.transferFile(trainerPhoto, path);
        trainerService.editTrainer(trainer);
        return "redirect:/trainer/trainerPersonalInfo?savedSuccessful";
    }

    @RequestMapping("/trainerClients")
    public String trainerClients(Model model, @AuthenticationPrincipal User activeUser){
        Trainer trainer = trainerService.getTrainerByUsername(activeUser.getUsername());
        List<Client> clientList = trainer.getClients();
        model.addAttribute("clientList", clientList);
        return "trainerClients";
    }
    @RequestMapping("/clientInfo/{clientId}")
    public String clientInfo(@PathVariable int clientId, Model model){
        Client client = clientService.getClientById(clientId);
        model.addAttribute("client", client);
        return "clientInfo";
    }

    @RequestMapping("/makeTraining/{clientId}")
    public String makeTraining(@PathVariable int clientId, Model model){
        List<Exercise> exerciseList = exerciseService.getExerciseList();
        model.addAttribute("exerciseList", exerciseList);
        ExerciseItem item = new ExerciseItem();
        model.addAttribute("item", item);
        model.addAttribute("clientId", clientId);
        return "makeTraining";
    }




}
