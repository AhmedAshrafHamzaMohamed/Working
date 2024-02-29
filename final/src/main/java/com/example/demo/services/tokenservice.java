package com.example.demo.services;


import java.time.Instant;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.stereotype.Service;

@Service
public class tokenservice {
    @Autowired
    private JwtEncoder jwtEncoder;
    @Autowired
    private JwtDecoder jwtDecoder;
    public String generateJwt(Authentication auth){
        Instant now=Instant.now();
        String scope=auth.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.joining(" "));
        
        return null;

    }
}
