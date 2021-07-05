package com.example.practicespringboot.controllers;

import com.example.practicespringboot.entities.User;
import com.example.practicespringboot.forms.UserForm;
import com.example.practicespringboot.services.IUserService;
import com.example.practicespringboot.viewmodels.UserListViewModel;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import javax.validation.groups.Default;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private final IUserService IUserService;

    public UserController(IUserService IUserService) {
        this.IUserService = IUserService;
    }

    @GetMapping("")
    public ModelAndView get(ModelAndView mav){
        List<User> users = IUserService.findAll();

        mav.addObject("model",new UserListViewModel(users));
        mav.setViewName("user_list");

        return mav;
    }

    @GetMapping("/new")
    public ModelAndView create(ModelAndView mav, @ModelAttribute UserForm userForm){
        mav.setViewName("user_create");

        return mav;
    }

    @PostMapping("/create")
    public ModelAndView createUser(ModelAndView mav, @Valid UserForm userForm,
                                   BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            mav.setViewName("user_create");
            return mav;
        }
        IUserService.createUser(userForm);
        mav.setViewName("redirect:/users");

        return mav;
    }

    @PostMapping("/delete")
    public ModelAndView deleteUser(ModelAndView mav, Long id){
        IUserService.deleteUser(id);
        mav.setViewName("redirect:/users");

        return mav;
    }

    @GetMapping("{id}/edit")
    public ModelAndView editUser(ModelAndView mav, @PathVariable Long id, UserForm userForm){
        User user = IUserService.getById(id);

        // 編集対象のユーザー情報をUserFormにセットする
        userForm.setEmail(user.getEmail());
        userForm.setName(user.getName());
        userForm.setGender(user.getGender());
        userForm.setLoginId(user.getLoginId());

        mav.addObject("id", id);
        mav.addObject("userForm", userForm);
        mav.setViewName("user_edit");

        return mav;
    }

    @PostMapping("{id}/update")
    public ModelAndView updateUser(ModelAndView mav, @PathVariable Long id,
                                   @Validated UserForm userForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            mav.setViewName("user_edit");
            return mav;
        }

        IUserService.updateUser(id, userForm);

        mav.setViewName("redirect:/users");

        return mav;
    }
}
