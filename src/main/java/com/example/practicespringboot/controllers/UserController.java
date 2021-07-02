package com.example.practicespringboot.controllers;

import com.example.practicespringboot.entity.User;
import com.example.practicespringboot.service.IUserService;
import com.example.practicespringboot.viewmodel.UserListViewModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    private final IUserService IUserService;

    public UserController(IUserService IUserService) {
        this.IUserService = IUserService;
    }

    @GetMapping("/get")
    public ModelAndView get(ModelAndView mav){
        List<User> users = IUserService.findAll();

        mav.addObject("model",new UserListViewModel(users));
        mav.setViewName("user_list");

        return mav;
    }
}
