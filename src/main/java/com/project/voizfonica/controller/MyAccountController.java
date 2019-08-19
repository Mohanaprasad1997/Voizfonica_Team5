package com.project.voizfonica.controller;

import com.project.voizfonica.data.MyAccountRepository;
import com.project.voizfonica.model.Login;
import com.project.voizfonica.model.MyAccount;
import com.project.voizfonica.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller

@RequestMapping("/myaccount")
@SessionAttributes({"login", "order"})
public class MyAccountController {
    @Autowired
    private MyAccountRepository myAccountRepository;
    @GetMapping
    public String get(Model model, @SessionAttribute Login login, @SessionAttribute Order order){
        List<MyAccount> myAccount=new ArrayList<>();
        myAccountRepository.findAll().forEach(i->myAccount.add(i));
        model.addAttribute("loginContact",login.getContact());

        return "myaccount";
    }
}
