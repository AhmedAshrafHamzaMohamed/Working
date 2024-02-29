package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserDTO;
import com.example.demo.entitiy.User;
import com.example.demo.services.authservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/auth")
public class authcontroller {
    @Autowired
    private authservice authserver;
    @PostMapping("/register") 
    public User registerUser(@RequestBody UserDTO user){
        return authserver.registerUser(user.getUsername(), user.getPassword());
    }
}
