package com.leverx.dealers.controller;

import com.leverx.dealers.entity.User;
import com.leverx.dealers.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserControllerImpl implements UserController{

    private UserRepository userRepository;

    @Autowired
    public UserControllerImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    @Override
    public List<User> allUsers() {
        return userRepository.findAll();
    }
}
