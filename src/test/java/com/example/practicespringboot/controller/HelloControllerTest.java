package com.example.practicespringboot.controller;

import com.example.practicespringboot.controllers.UserController;
import com.example.practicespringboot.entity.User;
import com.example.practicespringboot.mocks.MockUserService;
import com.example.practicespringboot.viewmodel.UserListViewModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@SpringBootTest
public class HelloControllerTest {

    private UserController userController;
    private final ArrayList<User> testUsers;

    public HelloControllerTest() {
        testUsers = new ArrayList<>();
        User testUser1 = new User();
        testUsers.add(testUser1);
    }

    @BeforeEach
    public void setUp() {
        MockUserService mockUserService = new MockUserService(testUsers);
        userController = new UserController(mockUserService);
    }

    @Test
    @DisplayName("Test!")
    public void test() {
        UserListViewModel expectedUserListViewModel = new UserListViewModel(testUsers);

        ModelAndView actual = userController.get(new ModelAndView());

        Assertions.assertEquals(expectedUserListViewModel, actual.getModel().get("model"));
        Assertions.assertEquals("user_list", actual.getViewName());
    }
}
