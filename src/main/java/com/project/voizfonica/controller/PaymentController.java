package com.project.voizfonica.controller;


import com.project.voizfonica.data.OrderRepository;
import com.project.voizfonica.data.PaymentRepository;
import com.project.voizfonica.model.Order;
import com.project.voizfonica.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/payment")
@SessionAttributes("order")
public class PaymentController {

    private final PaymentRepository PayRepo;
    private final OrderRepository orderRepository;
    @Autowired
    public PaymentController(PaymentRepository PayRepo,OrderRepository orderRepository)
    {
        this.PayRepo = PayRepo;
        this.orderRepository=orderRepository;

    }

    @ModelAttribute
    @GetMapping
    public String showPayment(Model model){
        model.addAttribute("payment",new Payment());
        return "payment";
    }
    @PostMapping
    public String processPayment(@Valid Payment payment, @ModelAttribute Order order, Errors errors) {
        if (errors.hasErrors()) {
            return "payment";
        }
        order.setPayment(payment);
        PayRepo.save(payment);
        orderRepository.save(order);
        return "paymentsuccess";
    }

}

