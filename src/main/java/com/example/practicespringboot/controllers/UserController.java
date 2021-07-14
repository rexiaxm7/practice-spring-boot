package com.example.practicespringboot.controllers;

import com.example.practicespringboot.domains.User;
import com.example.practicespringboot.forms.UserCreateForm;
import com.example.practicespringboot.forms.UserEditForm;
import com.example.practicespringboot.forms.UserListForm;
import com.example.practicespringboot.services.IUserService;
import com.example.practicespringboot.utils.UserConverter;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserConverter userConverter;

    private final IUserService userService;

    public UserController(IUserService userService, UserConverter userConverter) {
        this.userService = userService;
        this.userConverter = userConverter;
    }

    @GetMapping("")
    public ModelAndView get(ModelAndView mav) {
        List<User> users = userService.findAll();

        UserListForm attributeValue = userConverter.ToListForm(users);
        mav.addObject("model", attributeValue);
        mav.setViewName("user_list");

        return mav;
    }

    @GetMapping("/new")
    public ModelAndView create(ModelAndView mav, @ModelAttribute UserCreateForm userForm) {
        mav.setViewName("user_create");

        return mav;
    }

    @PostMapping("/new")
    public ModelAndView createUser(ModelAndView mav, @Valid UserCreateForm userForm,
                                   BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            mav.setViewName("user_create");
            return mav;
        }
        userService.createUser(userConverter.ToUser(userForm));
        mav.setViewName("redirect:/users");

        return mav;
    }

    @PostMapping("/delete")
    public ModelAndView deleteUser(ModelAndView mav, Long id) {
        userService.deleteUser(id);
        mav.setViewName("redirect:/users");

        return mav;
    }

    @GetMapping("{id}/edit")
    public ModelAndView editUser(ModelAndView mav, @PathVariable Long id) {
        mav.addObject("id", id);
        User user = userService.getById(id);


        // 編集対象のユーザー情報をUserFormにセットする
        mav.addObject("userEditForm", userConverter.ToEditForm(user));
        mav.setViewName("user_edit");

        return mav;
    }

    @PostMapping("{id}/edit")
    public ModelAndView updateUser(ModelAndView mav, @PathVariable Long id,
                                   @Valid UserEditForm userEditForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            mav.setViewName("user_edit");
            return mav;
        }

        userService.updateUser(id, userConverter.ToUser(userEditForm));

        mav.setViewName("redirect:/users");

        return mav;
    }
}
