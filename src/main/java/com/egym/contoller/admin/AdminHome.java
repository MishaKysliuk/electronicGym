package com.egym.contoller.admin;

import com.egym.model.Client;
import com.egym.model.GymPass;
import com.egym.service.ClientService;
import com.egym.service.GymPassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by MichaelMAC on 10.01.17.
 */
@Controller
@RequestMapping("/admin")
public class AdminHome {
    @Autowired
    private GymPassService gymPassService;

    @Autowired
    private ClientService clientService;

    /**
     * Request mapping method for admin page
     */
    @RequestMapping
    public String adminPage() {
        return "admin";
    }

    /**
     * Request mapping method for gym pass inventory. Adds list of gym passes to spring model
     */
    @RequestMapping("/gymPassInventory")
    public String productInventory(Model model) {
        List<GymPass> products = gymPassService.getGymPassList();
        model.addAttribute("gymPasses", products);

        return "gymPassInventory";
    }

    /**
     * Request mapping method for client management page. Adds list of clients to spring model.
     */
    @RequestMapping("/client")
    public String clientManagement(Model model) {

        List<Client> clientList = clientService.getAllClients();
        model.addAttribute("clientList", clientList);
        return "clientManagement";
    }
}
