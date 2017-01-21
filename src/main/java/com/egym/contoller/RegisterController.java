package com.egym.contoller;

import com.egym.model.Payment;
import com.egym.model.Client;
import com.egym.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by MichaelMAC on 11.01.17.
 */
@Controller
public class RegisterController {

    @Autowired
    private ClientService clientService;

    @RequestMapping("/register")
    public String registerCustomer(Model model) {

        Client client = new Client();

        model.addAttribute("client", client);

        return "registerClient";

    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerCustomerPost(@Valid @ModelAttribute("client") Client client, BindingResult result, Model model) {

        List<Client> clientList=clientService.getAllClients();

        for (int i=0; i< clientList.size(); i++) {
            if(client.getClientEmail().equals(clientList.get(i).getClientEmail())) {
                model.addAttribute("emailMsg", "Email already exists");

                return "registerClient";
            }

            if(client.getUsername().equals(clientList.get(i).getUsername())) {
                model.addAttribute("usernameMsg", "Username already exists");

                return "registerClient";
            }
        }
        if (result.hasErrors()) {
            return "registerClient";
        }
        
        client.setEnabled(true);
        clientService.addClient(client);

        return "registerClientSuccess";

    }
}
