package com.example.restfulwebservices.controller;

import com.example.restfulwebservices.model.User;
import com.example.restfulwebservices.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
    public User getUser(@PathVariable(name = "id") Integer id){
        return userService.findById(id);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUsers(@PathVariable(name = "id") Integer id){
        userService.deleteById(id);
    }

    @PostMapping("/users")
    public ResponseEntity<User> addUser(@RequestBody User user){
        User userAdded = userService.add(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(userAdded.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
}
