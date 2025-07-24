package org.example.springrestclient.controller;

import org.example.springrestclient.model.UserModel;
import org.example.springrestclient.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    public UserController(UserService service) {
        this.userService = service;
    }

    @GetMapping("/users")
    public List<UserModel> getAllUsers() {
        return userService.getAllUsers();
    }

}
