package com.project.voizfonica.controller;

import com.project.voizfonica.data.NewConnectionRepository;
import com.project.voizfonica.model.Login;
import com.project.voizfonica.model.NewConnection;
import com.project.voizfonica.model.SignUp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/editprofileendresult")
@SessionAttributes("signUp")

public class EditprofileEndResultController {


    @ModelAttribute
    @GetMapping
    public String show(Model model, @SessionAttribute("signUp")SignUp signUp){

        model.addAttribute("signUp",new SignUp());
        return "editprofileendresult";
    }

}
