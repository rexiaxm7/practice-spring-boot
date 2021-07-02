package com.example.practicespringboot.controller;

import com.example.practicespringboot.entity.User;
import com.example.practicespringboot.model.UserListModel;
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

        mav.addObject("model",new UserListModel(users));
        mav.setViewName("user/list");

        return mav;
    }
}
