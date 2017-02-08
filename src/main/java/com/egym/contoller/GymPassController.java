package com.egym.contoller;

import com.egym.model.GymPass;
import com.egym.service.GymPassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;

/**
 * Created by MichaelMAC on 10.01.17.
 */
@Controller
@RequestMapping("/gymPass")
public class GymPassController {

    @Autowired
    private GymPassService gymPassService;

    /**
     * Request mapping for gym passes page. List of gym passes is added to spring model.
     */
    @RequestMapping("/passList")
    public String getProducts(Model model) {
        List<GymPass> gymPasses = gymPassService.getGymPassList();
        model.addAttribute("gymPasses", gymPasses);

        return "passList";
    }

    /**
     * Request mapping for gym pass info page.
     * @param passId id of pass to be shown
     * @throws IOException
     */
    @RequestMapping("/viewPass/{passId}")
    public String viewProduct(@PathVariable int passId, Model model) throws IOException {
        GymPass gymPass = gymPassService.getGymPassById(passId);
        model.addAttribute("gymPass", gymPass);

        return "viewPass";
    }
}
