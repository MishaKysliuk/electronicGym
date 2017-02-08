package com.egym.contoller.admin;

import com.egym.model.Client;
import com.egym.model.GymPass;
import com.egym.model.Trainer;
import com.egym.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by MichaelMAC on 14.01.17.
 */
@Controller
@RequestMapping("/admin")
public class AdminTrainer {

    @Autowired
    private TrainerService trainerService;

    /**
     * Request mapping method for registering trainer. Adds trainer object to spring model
     */
    @RequestMapping("/registerTrainer")
    public String registerTrainer(Model model){
        Trainer trainer = new Trainer();
        model.addAttribute("trainer", trainer);

        return "registerTrainer";
    }

    /**
     * POST method for registering trainer. Checks whether data is valid and then saves data into database.
     * @param trainer trainer from model
     * @param result binding result from validation
     */
    @RequestMapping(value = "/registerTrainer", method = RequestMethod.POST)
    public String registerTrainer(@Valid @ModelAttribute("trainer") Trainer trainer, BindingResult result, Model model){

        List<Trainer> trainerList=trainerService.getAllTrainers();

        for (int i=0; i< trainerList.size(); i++) {
            if(trainer.getTrainerEmail().equals(trainerList.get(i).getTrainerEmail())) {
                model.addAttribute("emailMsg", "Email already exists");

                return "registerTrainer";
            }

            if(trainer.getUsername().equals(trainerList.get(i).getUsername())) {
                model.addAttribute("usernameMsg", "Username already exists");

                return "registerTrainer";
            }
        }
        if (result.hasErrors()) {
            return "registerTrainer";
        }

        trainer.setEnabled(true);
        trainerService.addTrainer(trainer);

        return "redirect:/admin/trainer";
    }

    /**
     * Request mapping method for trainer management page. Adds trainer list to spring model.
     */
    @RequestMapping("/trainer")
    public String trainerManagement(Model model) {

        List<Trainer> trainerList = trainerService.getAllTrainers();
        model.addAttribute("trainerList", trainerList);
        return "trainerManagement";
    }
}
