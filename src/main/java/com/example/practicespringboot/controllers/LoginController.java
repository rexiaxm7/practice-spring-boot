package com.example.practicespringboot.controllers;

import com.example.practicespringboot.forms.LoginForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
    @GetMapping("/login")
    public ModelAndView login(ModelAndView mav, @ModelAttribute LoginForm loginForm){
        mav.setViewName("login");
        return mav;
    }
}
