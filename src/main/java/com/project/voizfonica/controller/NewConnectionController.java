package com.project.voizfonica.controller;



import com.project.voizfonica.data.NewConnectionRepository;
import com.project.voizfonica.model.NewConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

@Controller

@RequestMapping("/newconnection")
@SessionAttributes("newconnection")
public class NewConnectionController {
    @Autowired
    private NewConnectionRepository newConnectionRepository;
    @Autowired
    private JavaMailSender javaMail;

    @GetMapping
    public String get(Model model, SessionStatus sessionStatus){
        sessionStatus.setComplete();
        model.addAttribute("newconnection",new NewConnection());
        return "newconnection";
    }
    @PostMapping
    public String post(@Valid NewConnection newConnection, Errors errors, Model model){

        SimpleMailMessage msg=new SimpleMailMessage();
        msg.setTo(newConnection.getEmail());
        msg.setSubject("Welcome to VoizFonica!");
        msg.setText("Congratulations Your New Connection is Successful!!!\nYour new SIM card can be collected from nearby voizfonica premises");
        javaMail.send(msg);
        newConnectionRepository.save(newConnection);
       model.addAttribute("newconnection",newConnection);
        return "newconnectionendresult";
    }


}
