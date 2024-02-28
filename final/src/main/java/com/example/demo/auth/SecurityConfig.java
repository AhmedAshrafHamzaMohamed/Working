package com.example.demo.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
//import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig{
/*
@Override
protected void configure(HttpSecurity http) throws Exception {
    http
    .cors().and().csrf().disable()
    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
    .authorizeRequests()
    .anyRequest().permitAll();
} */ 
@Bean
public PasswordEncoder passwordEncoder()
{

    return new BCryptPasswordEncoder();
    
}

@Bean
public AuthenticationManager authenticationManager (UserDetailsService detailsService)
{
    DaoAuthenticationProvider daoAuthenticationProvider=new DaoAuthenticationProvider();
    daoAuthenticationProvider.setUserDetailsService(detailsService);
    return new ProviderManager(daoAuthenticationProvider);
}
@Bean
public SecurityFilterChain filterChain(HttpSecurity http)throws Exception
{
   return http
   .csrf(csrf->csrf.disable())
   .authorizeHttpRequests(auth -> 
       //auth.requestMatchers(HttpMethod.POST,"/**").permitAll() // Allow all POST requests without authentication
       //auth.anyRequest().permitAll()  
       auth.anyRequest().authenticated() // Require authentication for all other requests
   ).httpBasic(Customizer.withDefaults())
   .build();        
    
}
}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    
