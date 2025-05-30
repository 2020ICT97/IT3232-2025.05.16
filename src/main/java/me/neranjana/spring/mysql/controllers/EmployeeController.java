package me.neranjana.spring.mysql.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.neranjana.spring.mysql.models.Employee;
import me.neranjana.spring.mysql.services.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    public EmployeeService service;

    @GetMapping("/salary-range")
    public ResponseEntity<List<Employee>> getEmployeesInSalaryRange() {
        return new ResponseEntity<List<Employee>>(service.getEmployeesInSalaryRange(), HttpStatus.OK);
    }

    @GetMapping("/department/{id}")
    public ResponseEntity<List<Employee>> getEmployeesByDepartment(@PathVariable("id") String id) {
        return new ResponseEntity<List<Employee>>(service.getEmployeesByDepartment(id), HttpStatus.OK);
    }

    @GetMapping("/youngest-female")
    public ResponseEntity<Employee> getYoungestFemaleEmployee() {
        return new ResponseEntity<Employee>(service.getYoungestFemaleEmployee(), HttpStatus.OK);
    }

}
