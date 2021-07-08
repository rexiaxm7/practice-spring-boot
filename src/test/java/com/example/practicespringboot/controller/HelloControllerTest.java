package com.example.practicespringboot.controller;

import com.example.practicespringboot.controllers.UserController;
import com.example.practicespringboot.domains.User;
import com.example.practicespringboot.mocks.MockUserService;
import com.example.practicespringboot.forms.UserListForm;
import com.example.practicespringboot.utils.UserConverter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@SpringBootTest
public class HelloControllerTest {

    private UserController userController;
    private final ArrayList<User> testUsers;
    private final UserConverter userConverter;

    public HelloControllerTest() {
        testUsers = new ArrayList<>();
        User user = new User();
        testUsers.add(user);
        userConverter = new UserConverter(new BCryptPasswordEncoder());
    }

    @BeforeEach
    public void setUp() {
        MockUserService mockUserService = new MockUserService(testUsers);
        userController = new UserController(mockUserService, userConverter);
    }

    @Test
    @DisplayName("Test!")
    public void test() {
        UserListForm expectedUserListViewModel = userConverter.ToListForm(testUsers);

        ModelAndView actual = userController.get(new ModelAndView());

        Assertions.assertEquals(expectedUserListViewModel, actual.getModel().get("model"));
        Assertions.assertEquals("user_list", actual.getViewName());
    }
}
