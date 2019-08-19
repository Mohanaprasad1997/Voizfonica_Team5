package com.project.voizfonica.controller;

import com.project.voizfonica.data.SignUpRepository;
import com.project.voizfonica.model.Login;
import com.project.voizfonica.model.Order;
import com.project.voizfonica.model.SignUp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/login")
@SessionAttributes({"login", "order"})
public class LoginController {

    private SignUpRepository signUpRepository;
    @Autowired
    private LoginController(SignUpRepository signUpRepository)
    {
        this.signUpRepository = signUpRepository;
    }

    @GetMapping
    public String showLogin(Model model) {
        model.addAttribute("login", new Login());
        model.addAttribute("order",new Order());
        return "login";
    }
    @PostMapping
    public String processLogin(@Valid @ModelAttribute Login login, @ModelAttribute Order order, Errors errors, Model model) {
        if (errors.hasErrors()) {

            return "login";
        } else {
            List<SignUp> user=signUpRepository.findByContactAndPassword(login.getContact(),login.getPassword());

            if (user.isEmpty()) {
                errors.rejectValue("password","password invalid","invalid password");
                return "redirect:/login";
            } else {
                login.setContact(login.getContact());
                order.setUserid(login.getContact());
                model.addAttribute("order",order);

                return "redirect:/dashboard";
            }
        }

    }
}
