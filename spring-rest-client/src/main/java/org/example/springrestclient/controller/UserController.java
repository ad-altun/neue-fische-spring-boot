package org.example.springrestclient.controller;

import org.example.springrestclient.dto.UserDataDto;
import org.example.springrestclient.dto.UserDto;
import org.example.springrestclient.model.UserModel;
import org.example.springrestclient.service.UserService;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/users")
    public UserDataDto createUser(@RequestBody UserDto newUser) {
        return userService.createUser(newUser);
    }
}
