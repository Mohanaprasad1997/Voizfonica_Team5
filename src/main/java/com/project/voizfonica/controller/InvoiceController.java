package com.project.voizfonica.controller;

import com.project.voizfonica.data.InvoiceRepository;
import com.project.voizfonica.model.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

@Controller
@RequestMapping("/invoice")

@SessionAttributes("invoice")
public class InvoiceController {
    private InvoiceRepository invoiceRepository;
    @Autowired
    public InvoiceController(InvoiceRepository invoiceRepository){
        this.invoiceRepository=invoiceRepository;
    }

    @GetMapping
    public String show_register(Model model, SessionStatus sessionStatus){
        sessionStatus.setComplete();
        model.addAttribute("invoice",new Invoice());
        return "invoice";
    }
    @PostMapping
    public String processInvoice(@Valid Invoice invoice, Errors errors,Model model) {
        if (errors.hasErrors()) {
            return "redirect:/invoice";
        }
        invoiceRepository.save(invoice);

        return "invoicebills";
    }

}