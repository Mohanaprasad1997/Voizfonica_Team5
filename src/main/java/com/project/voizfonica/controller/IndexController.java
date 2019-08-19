package com.project.voizfonica.controller;

import com.project.voizfonica.data.IndexRepository;
import com.project.voizfonica.model.Index;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class IndexController {
    @Autowired
    private IndexRepository indexRepository;

    @GetMapping
    public String showindex(Model model, SessionStatus sessionStatus){
        sessionStatus.setComplete();
        model.addAttribute("index",new Index());
        return "index";
    }
    @PostMapping
    public String processPay(@Valid Index index, Errors errors, Model model){

        indexRepository.save(index);

        return "/pay";
    }


}
