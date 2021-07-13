package com.example.demo.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.web.server.ResponseStatusException;


@RestController
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping(value = "/user/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @PostMapping("/user")
    public String createUser(@RequestBody User user) {
        user.setDateOfBirthday(user.getDateOfBirthday());
        try {
            userService.saveUser(user);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User already registered!", e);
        }
        return "Saved";
    }
}