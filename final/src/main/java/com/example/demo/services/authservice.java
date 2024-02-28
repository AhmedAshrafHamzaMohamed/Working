package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entitiy.Role;
import com.example.demo.entitiy.User;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;

@Service
@Transactional
public class authservice {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    public User registerUser(String Name,String password)
    {
        password=passwordEncoder.encode(password);
        List<Role> r=roleRepository.findByAuthority("USER");
        return userRepository.save(new User(3,Name,"mail",password,r));

        
    }

}
