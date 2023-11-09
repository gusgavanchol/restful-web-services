package com.example.restfulwebservices.service;

import com.example.restfulwebservices.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(Integer id);
    void add(User user);
}
