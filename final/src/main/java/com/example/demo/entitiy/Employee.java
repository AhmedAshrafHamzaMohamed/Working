package com.example.demo.entitiy;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name="employees")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(name="Name",nullable = true)
    private String Name;
    @Column(name="NID",nullable = true)
    private Long NID;
    @Column(name="Salary",nullable = true)
    private int Salary;
    @Column(name="WorkingDays",nullable = true)
    private int WorkingDays;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "department_id")
    Department department;
}
