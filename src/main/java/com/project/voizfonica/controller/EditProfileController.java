package com.project.voizfonica.controller;

import com.project.voizfonica.data.SignUpRepository;
import com.project.voizfonica.model.Login;
import com.project.voizfonica.model.SignUp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/editprofile")
@SessionAttributes({"signup", "login"})
public class EditProfileController {

    private SignUpRepository signUpRepo;
    private String userId;

    @Autowired
    private EditProfileController(SignUpRepository signUpRepo) {
        this.signUpRepo = signUpRepo;

    }

    @ModelAttribute(name = "signUp")
    public SignUp signUp() {
        return new SignUp();
    }

    @GetMapping
    public String getEdit(@SessionAttribute Login login, Model model) {

        List<SignUp> user = signUpRepo.findByContact(login.getContact());
        model.addAttribute("user", user);
        model.addAttribute("loginContact",login.getContact());
        return "editprofile";
    }

    @PostMapping
    public String setChanges(@SessionAttribute Login login,@Valid SignUp signUp, Errors errors, Model model) {
        List<SignUp> user = signUpRepo.findByContact(login.getContact());
        userId = (String) user.get(0).getId();
        SignUp signUp1 = new SignUp();
        signUp1.setId(userId);
        signUp1.setUsername(signUp.getUsername());
        signUp1.setPassword(signUp.getPassword());
        signUp1.setEmail(signUp.getEmail());
        signUp1.setCity(signUp.getCity());
        signUp1.setContact(login.getContact());
        signUp1.setAddress1(signUp.getAddress1());
        signUp1.setAddress2(signUp.getAddress2());
        signUp1.setState(signUp.getState());
        signUp1.setZip(signUp.getZip());
        signUpRepo.save(signUp1);
        return "editprofileendresult";

    }

}

