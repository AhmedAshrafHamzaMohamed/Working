package com.example.demo.entitiy;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;
@Entity
@Table(name="departments")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(name="Name",nullable = true)
    private String Name;
    @OneToMany(mappedBy = "department")
    List<Employee> employees=new ArrayList<>();

    public Department(Long id,String name){
        Name=name;
        Id=id;
    }
    public Department(String name){
        Name=name;
    }
}
