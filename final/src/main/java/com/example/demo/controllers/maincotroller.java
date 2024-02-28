package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.DepartmentDTO;
import com.example.demo.dto.EmployeeDTO;
//import com.example.demo.entitiy.Department;
import com.example.demo.services.mainservice;
import java.util.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
public class maincotroller {

@Autowired
mainservice mainservice;


@PostMapping("/addDepart/{entity}")
public void addDepartment(@PathVariable String entity) {
    mainservice.enterDataForDepartments(entity);
}

@GetMapping("/getDepartments")
public List<DepartmentDTO> getDepartments() {    
    return mainservice.getDepartmentDTOs();
}
@GetMapping("/getEmployees")
public List<EmployeeDTO> getEmployees() {
    return mainservice.getEmployeeDTOs();
    
}
@PostMapping("/addEmployee")
public void addEmployee(@RequestBody EmployeeDTO entity) {
    mainservice.enterDataForEmployees(entity);
}


    
}
