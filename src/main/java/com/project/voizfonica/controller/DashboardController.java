package com.project.voizfonica.controller;

import com.project.voizfonica.data.DashboardRepository;
import com.project.voizfonica.model.Dashboard;
import com.project.voizfonica.model.Login;
import lombok.RequiredArgsConstructor;
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
@RequestMapping("/dashboard")
@SessionAttributes("login")
public class DashboardController {

    @Autowired
    private DashboardRepository dashrepo;


    @GetMapping
    public String rundashboard(Model model, @SessionAttribute("login") Login login)
    {
        List<Dashboard> dash=new ArrayList<>();
        dashrepo.findAll().forEach(i->dash.add(i));
        model.addAttribute("dash",dash);
        model.addAttribute("loginContact",login.getContact());
        return "dashboard";
    }
}
