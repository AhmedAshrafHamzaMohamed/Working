package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entitiy.Department;
import com.example.demo.entitiy.Employee;
import com.example.demo.entitiy.Role;
import com.example.demo.entitiy.User;
import com.example.demo.repository.EmployeeRepository;
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
    @Autowired
    EmployeeRepository employeeRepository;
    public User registerUser(String Name,String password)
    {
        password=passwordEncoder.encode(password);
        List<Role> r=roleRepository.findByAuthority("USER");
        Department department=new Department((long) 1,"IT");
        employeeRepository.save(new Employee((long)1,Name,(long)789,8500,5,department));
        return userRepository.save(new User(Name,"mailttnt",password,r));

        
    }

}
