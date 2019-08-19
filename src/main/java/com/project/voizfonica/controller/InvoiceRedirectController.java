package com.project.voizfonica.controller;


import com.project.voizfonica.model.Invoice;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/invoicebills")
@SessionAttributes("invoice")

public class InvoiceRedirectController {
    @ModelAttribute
    @GetMapping
    public String show(Model model, @SessionAttribute("invoice") Invoice invoice) {

        model.addAttribute("invoice", new Invoice());
        return "invoicebills";
    }
}