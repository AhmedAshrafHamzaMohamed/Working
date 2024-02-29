package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entitiy.User;

public interface UserRepository extends JpaRepository<User,Long> {
    @Query(value = "SELECT * FROM USERS WHERE USERS.USERNAME=?1",nativeQuery = true)
    User findUserByName(String name);
}
