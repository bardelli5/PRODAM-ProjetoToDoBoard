package com.example.demo.controller;

import com.example.demo.entities.User;
import com.example.demo.services.AuthenticationService;
import com.example.demo.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@SessionAttributes({"user"})
@Controller
public class LoginController {

    @Autowired
    private AuthenticationService authenticationService;
    @Autowired
    private LoginService loginService;

    @GetMapping("/")
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView("login.html");
        modelAndView.addObject("user", new User());
        modelAndView.addObject("isPasswordIncorrect", false);

        return modelAndView;
    }

    @PostMapping("/")
    public ModelAndView validarLogin(Model model, @ModelAttribute("user") User user) {
        return loginService.validateLogin(user);
    }

    @PostMapping("/todoboard")
    public ModelAndView cadastrarEEntrar(Model model, @ModelAttribute("user") User user) {
        return loginService.createNewUser(user);
    }
}
