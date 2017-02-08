package com.egym.contoller;

import com.egym.dao.GymPassDao;
import com.egym.model.GymPass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by MichaelMAC on 04.01.17.
 */
@Controller
public class HomeController {

    /**
     * Request mapping for home page
     */
    @RequestMapping("/")
    public String home(){
        return "home";
    }

    /**
     * Request mapping for login page. If there is error the appropriate text is shown.
     * If user log out the appropriate text is shown.
     * @param error
     * @param logout
     * @param model
     * @return
     */
    @RequestMapping("/login")
    public String login(@RequestParam(value = "error", required = false) String error,
                        @RequestParam(value = "logout", required = false) String logout, Model model){
        if(error != null){
            model.addAttribute("error", "Invalid username or password");
        }
        if(logout != null){
            model.addAttribute("msg", "You have been logged out successfully");
        }
        return "login";
    }

    /**
     * Request mapping for contacts page
     */
    @RequestMapping("/contacts")
    public String about() {
        return "contacts";
    }

}
