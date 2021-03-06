package com.egym.contoller.admin;

import com.egym.model.GymPass;
import com.egym.model.util.FileHelper;
import com.egym.service.GymPassService;
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
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by MichaelMAC on 11.01.17.
 */
@Controller
@RequestMapping("/admin")
public class AdminGymPass {

    private Path path;

    @Autowired
    private GymPassService gymPassService;

    /**
     * Request mapping method for adding gym pass.
     */
    @RequestMapping("/gymPass/addGymPass")
    public String addGymPass(Model model){
        GymPass gymPass = new GymPass();
        gymPass.setPassCategory("Full day");
        model.addAttribute("gymPass", gymPass);

        return "addGymPass";
    }

    /**
     * POST method for adding gym pass. Adds gym pass to db using service and copies image of gym pass to local directory.
     * @param gymPass gym pass from model
     * @param result binding result from validation
     * @param request http servlet request
     */
    @RequestMapping(value = "/gymPass/addGymPass", method = RequestMethod.POST)
    public String addGymPassPost(@Valid @ModelAttribute("gymPass") GymPass gymPass, BindingResult result, HttpServletRequest request){
        if (result.hasErrors()){
            return "addGymPass";
        }
        gymPassService.addGymPass(gymPass);

        MultipartFile gymPassImage = gymPass.getGymPassImage();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "WEB-INF/resources/images/" + gymPass.getPassId() + ".png");

        FileHelper.transferFile(gymPassImage, path);

        return "redirect:/admin/gymPassInventory";
    }

    /**
     * Request mapping method for editing gym pass
     * @param passId id of edited gym pass
     */
    @RequestMapping("/gymPass/editGymPass/{passId}")
    public String editGymPass(@PathVariable int passId, Model model){
        GymPass gymPass = gymPassService.getGymPassById(passId);

        model.addAttribute(gymPass);

        return "editGymPass";
    }

    /**
     * POST method for saving gym pass into db while editing is finished. Copies image to local directory.
     * @param gymPass gym pass from model
     * @param result binding result from validation
     * @param request http servlet request
     */
    @RequestMapping(value = "/gymPass/editGymPass/{passId}", method = RequestMethod.POST)
    public String editGymPass(@Valid @ModelAttribute("gymPass") GymPass gymPass, BindingResult result, Model model, HttpServletRequest request){
        if (result.hasErrors()){
            return "editGymPass";
        }
        MultipartFile gymPassImage = gymPass.getGymPassImage();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "WEB-INF/resources/images/" + gymPass.getPassId() + ".png");
        FileHelper.transferFile(gymPassImage, path);
        gymPassService.editGymPass(gymPass);
        return "redirect:/admin/gymPassInventory";
    }

    /**
     * Request mapping for deleting gym pass. Also deletes gym pass image
     * @param passId id of deleted gym pass
     * @param request http servlet request
     */
    @RequestMapping("/gymPass/deleteGymPass/{passId}")
    public String deleteGymPass(@PathVariable int passId, Model model, HttpServletRequest request){
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "WEB-INF/resources/images/" + passId + ".png");
        if(Files.exists(path)){
            try {
                Files.delete(path);
            } catch (IOException e) {
                e.printStackTrace();

            }
        }

        GymPass gymPass = gymPassService.getGymPassById(passId);
        gymPassService.deleteGymPass(gymPass);

        return "redirect:/admin/gymPassInventory";
    }

}
