package com.project.voizfonica.controller;

import com.project.voizfonica.model.Payment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/paymentsuccess")

public class PaymentSuccessController {


    @ModelAttribute
    @GetMapping
    public String show(Model model, Payment payment){

       model.addAttribute("payment",new Payment());
        return "paymentsuccess";
    }

}
