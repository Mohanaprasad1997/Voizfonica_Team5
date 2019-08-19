package com.project.voizfonica.controller;

import com.project.voizfonica.data.NewConnectionRepository;
import com.project.voizfonica.model.Login;
import com.project.voizfonica.model.NewConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/newconnectionendresult")
@SessionAttributes("newconnection")

public class NewConnectionEndResultController {


    @ModelAttribute
    @GetMapping
    public String show(Model model, @SessionAttribute("newconnection") NewConnection newConnection){

        model.addAttribute("newconnection",new NewConnection());
        return "newconnectionendresult";
    }




}
