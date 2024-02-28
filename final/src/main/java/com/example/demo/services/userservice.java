package com.example.demo.services;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entitiy.Role;
import com.example.demo.entitiy.User;
import com.example.demo.repository.UserRepository;
@Service
public class userservice implements UserDetailsService  {
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    UserRepository ur;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("In user details service");
        User user=ur.findUserByName(username);
        System.out.println(user);
        //if user==null || user.getPassword()!=
        if(!username.equals("ahmeds"))throw new  UsernameNotFoundException("Not ahmed");
        
        List<Role> roles=new ArrayList<>();
        roles.add(new Role(1,"USER"));
        return new User(1,"ahmeds","mail",encoder.encode("password"),roles);
    }
  
    
}
