package com.example.demo.dto;

import com.example.demo.entitiy.Department;
import com.example.demo.entitiy.Employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {

    private Long Id;

    private String Name;

    private Long NID;

    private int Salary;

    private int WorkingDays;

    private Long DepartmentId;

    public EmployeeDTO(Employee emp)
    {
        this.Id=emp.getId();
        this.NID=emp.getNID();
        this.Name=emp.getName();
        this.Salary=emp.getSalary();
        this.WorkingDays=emp.getWorkingDays();
        this.DepartmentId=emp.getDepartment().getId();
    }

    public Employee covertToEmployee(EmployeeDTO employeeDTO,Department department)
    {
        return new Employee(Id,Name,NID,Salary,WorkingDays,department);
    }
    
    
}
