package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.DepartmentDTO;
import com.example.demo.dto.EmployeeDTO;
import com.example.demo.entitiy.Department;
import com.example.demo.entitiy.Employee;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.EmployeeRepository;

@Service
public class mainservice {
    @Autowired
    DepartmentRepository dr;
    @Autowired
    EmployeeRepository er;

    public void enterDataForDepartments(String name) {
        System.out.println(name);
        dr.save(new Department(name));
    }

    public void enterDataForEmployees(EmployeeDTO employeeDTO) {
        er.save(employeeDTO.covertToEmployee(employeeDTO, dr.getReferenceById(employeeDTO.getDepartmentId())));

    }

    public List<DepartmentDTO> getDepartmentDTOs() {
        List<DepartmentDTO> res = new ArrayList<>();
        List<Department> ret = dr.findAll();
        for (int i = 0; i < ret.size(); i++) {
            System.out.println(ret.get(i));
            res.add(new DepartmentDTO(ret.get(i)));
        }

        return res;
    }

    public List<EmployeeDTO> getEmployeeDTOs() {
        List<EmployeeDTO> res = new ArrayList<>();
        List<Employee> ret = er.findAll();
        for (int i = 0; i < ret.size(); i++) {
            System.out.println(ret.get(i));
            res.add(new EmployeeDTO(ret.get(i)));
        }

        return res;
    }
}
