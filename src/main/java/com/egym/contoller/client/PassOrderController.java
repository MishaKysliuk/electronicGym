package com.egym.contoller.client;

import com.egym.model.Client;
import com.egym.model.GymPass;
import com.egym.model.PassOrder;
import com.egym.model.Payment;
import com.egym.service.ClientService;
import com.egym.service.GymPassService;
import com.egym.service.PassOrderService;
import com.egym.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.time.LocalDate;

/**
 * Created by MichaelMAC on 12.01.17.
 */
@Controller
@RequestMapping("/client")
public class PassOrderController {

    @Autowired
    private GymPassService gymPassService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private PassOrderService passOrderService;

    @RequestMapping("/gymPass/orderGymPass/{passId}")
    public String orderGymPass(@PathVariable(name = "passId") int passId, Model model, @AuthenticationPrincipal User activeUser){
        model.addAttribute("passId", passId);
        Client client = clientService.getClientByUsername(activeUser.getUsername());
        if(client.getGymPassExpirationDate() != null && client.getGymPassExpirationDate().isAfter(LocalDate.now()))
            model.addAttribute("msg", "You have already got gym pass! Do you want to buy another one?");
        Payment payment = new Payment();
        model.addAttribute("payment", payment);
        return "orderGymPass";
    }
    @RequestMapping(value = "/gymPass/orderGymPass/{passId}", method = RequestMethod.POST)
    public String orderGymPass(@Valid @ModelAttribute("payment") Payment payment, @PathVariable(name = "passId") int passId,
                               BindingResult result, Model model, @AuthenticationPrincipal User activeUser){
        if (result.hasErrors()){
            return "orderGymPass";
        }
        Client client = clientService.getClientByUsername(activeUser.getUsername());
        GymPass gymPass = gymPassService.getGymPassById(passId);
        PassOrder passOrder = new PassOrder();
        passOrder.setDate(LocalDate.now());
        passOrder.setPayment(payment);
        passOrder.setClient(client);
        passOrder.setGymPass(gymPass);
        passOrderService.addPassOrder(passOrder);
        client.setPassOrder(passOrder);
        client.setGymPassExpirationDate(passOrder.getDate().plusMonths(gymPass.getPassDurationInMonths()));
        clientService.editClient(client);

        return "redirect:/client/clientPassInfo?paymentSuccess";
    }
}
