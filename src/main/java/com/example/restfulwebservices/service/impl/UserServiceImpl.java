package com.example.restfulwebservices.service.impl;

import com.example.restfulwebservices.model.User;
import com.example.restfulwebservices.service.UserService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private static List<User> users = new ArrayList();

    static {
        users.add(new User(1, "Adam", LocalDate.now().minusYears(30)));
        users.add(new User(2, "Eve", LocalDate.now().minusYears(25)));
        users.add(new User(3, "Jim", LocalDate.now().minusYears(20)));
    }

    public List<User> findAll(){
        return users;
    }

    @Override
    public User findById(Integer id) {
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void add(User user) {
        users.add(user);
    }
}
