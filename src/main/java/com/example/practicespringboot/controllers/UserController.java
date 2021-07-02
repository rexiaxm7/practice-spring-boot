package com.example.practicespringboot.controllers;

import com.example.practicespringboot.entity.User;
import com.example.practicespringboot.viewmodel.UserListViewModel;
import com.example.practicespringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/get")
    public ModelAndView get(ModelAndView mav){
        List<User> users = userService.findAll();

        mav.addObject("model",new UserListViewModel(users));
        mav.setViewName("user_list");

        return mav;
    }
}
