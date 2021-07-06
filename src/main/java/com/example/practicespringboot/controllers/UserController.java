package com.example.practicespringboot.controllers;

import com.example.practicespringboot.entities.User;
import com.example.practicespringboot.forms.UserCreateForm;
import com.example.practicespringboot.forms.UserEditForm;
import com.example.practicespringboot.services.IUserService;
import com.example.practicespringboot.viewmodels.UserListViewModel;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public ModelAndView get(ModelAndView mav){
        List<User> users = userService.findAll();

        mav.addObject("model",new UserListViewModel(users));
        mav.setViewName("user_list");

        return mav;
    }

    @GetMapping("/new")
    public ModelAndView create(ModelAndView mav, @ModelAttribute UserCreateForm userForm){
        mav.setViewName("user_create");

        return mav;
    }

    @PostMapping("/create")
    public ModelAndView createUser(ModelAndView mav, @Valid UserCreateForm userForm,
                                   BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            mav.setViewName("user_create");
            return mav;
        }
        userService.createUser(userForm);
        mav.setViewName("redirect:/users");

        return mav;
    }

    @PostMapping("/delete")
    public ModelAndView deleteUser(ModelAndView mav, Long id){
        userService.deleteUser(id);
        mav.setViewName("redirect:/users");

        return mav;
    }

    @GetMapping("{id}/edit")
    public ModelAndView editUser(ModelAndView mav, @PathVariable Long id){
        mav.addObject("id", id);
        mav.addObject("userEditForm", userService.getUserOnForm(id));
        mav.setViewName("user_edit");

        return mav;
    }

    @PostMapping("{id}/update")
    public ModelAndView updateUser(ModelAndView mav, @PathVariable Long id,
                                   @Valid UserEditForm userEditForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            mav.setViewName("user_edit");
            return mav;
        }

        userService.updateUser(id, userEditForm);

        mav.setViewName("redirect:/users");

        return mav;
    }
}
