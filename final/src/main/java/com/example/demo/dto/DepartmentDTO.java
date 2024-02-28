package com.example.demo.dto;


import com.example.demo.entitiy.Department;

import lombok.Data;
@Data
public class DepartmentDTO {
    private String Name;


    public DepartmentDTO(Department department){
        Name=department.getName();
    }

 /*   public Department convertToDepartment(DepartmentDTO departmentDTO){
        return new Department()
    }*/
}
