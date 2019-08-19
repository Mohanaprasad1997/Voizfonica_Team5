package com.project.voizfonica.controller;


import com.project.voizfonica.data.OrderRepository;
import com.project.voizfonica.data.PlanRepository;
import com.project.voizfonica.data.SignUpRepository;
import com.project.voizfonica.model.Login;
import com.project.voizfonica.model.Order;
import com.project.voizfonica.model.Plan;
import com.project.voizfonica.model.SignUp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/plan")
@SessionAttributes({"login", "order"})
public class PlanController {

    private PlanRepository preRepo;
    private OrderRepository orderRepository;
    private SignUpRepository signUpRepository;
    @Autowired
    public PlanController(PlanRepository preRepo,OrderRepository orderRepository,SignUpRepository signUpRepository) {
        this.preRepo=preRepo;
        this.orderRepository=orderRepository;
        this.signUpRepository=signUpRepository;
    }

    @GetMapping
    public String postPlanFunc(Model model, @SessionAttribute("login") Login login) {
        List<Plan> plans=preRepo.findAll();
        model.addAttribute("plans",plans);
        model.addAttribute("loginContact",login.getContact());
        return  "plan";

    }

    @ModelAttribute(name = "order")
    public Order order(){
        return new Order();
    }

    @RequestMapping(value = "/{loginContact}/{id}",method = RequestMethod.GET)
    public String processOrder(@PathVariable String loginContact,@PathVariable String id, @ModelAttribute Order order,Model model){
        List<Plan> plans=new ArrayList<>();
        plans=preRepo.findAllById(id);
        order.setPlan(plans.get(0));
        orderRepository.save(order);
        List<SignUp> signUps=new ArrayList<>();
        signUps=signUpRepository.findAllByContact(loginContact);
        order.setUser(signUps.get(0));
        orderRepository.save(order);
        return "redirect:/payment";
    }
    @PostMapping
    public String processPlanFrom(@Valid PlanController planController, Model model){
        model.addAttribute("payment",planController);
        return "redirect:/payment";
    }

}