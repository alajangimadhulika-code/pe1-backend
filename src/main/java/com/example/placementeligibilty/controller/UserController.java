package com.example.placementeligibilty.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.example.placementeligibilty.model.User;
import com.example.placementeligibilty.service.UserService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3001")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return service.register(user);
    }

    @PostMapping("/login")
    public User login(@RequestBody User user) {
        User found = service.login(user.getEmail(), user.getPassword());
        if (found == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid email or password");
        }
        return found;
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        return "Welcome to Dashboard!";
    }
}
