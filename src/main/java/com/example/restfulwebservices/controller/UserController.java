package com.example.restfulwebservices.controller;

import com.example.restfulwebservices.model.User;
import com.example.restfulwebservices.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getUsers(){
        return userService.findAll();
    }

    @GetMapping("/users/{id}")
    public User getUsers(@PathVariable(name = "id") Integer id){
        return userService.findById(id);
    }

    @PostMapping("/users")
    public void addUser(@RequestBody User user){
        userService.add(user);
    }
}
