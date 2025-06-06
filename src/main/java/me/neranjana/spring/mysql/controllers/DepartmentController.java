package me.neranjana.spring.mysql.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.neranjana.spring.mysql.models.Department;
import me.neranjana.spring.mysql.models.ViewDepartment;
import me.neranjana.spring.mysql.services.DepartmentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/departments")
public class DepartmentController {
    @Autowired
    public DepartmentService service;

    @GetMapping
    public ResponseEntity<List<Department>> getDepartments() {
        return new ResponseEntity<List<Department>>(service.getDepartments(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable("id") String id) {
        return new ResponseEntity<Department>(service.getDepartmentById(id), HttpStatus.OK);
    }
    
    @GetMapping("/names")
    public ResponseEntity<List<String>> getDepartmentNames() {
        return new ResponseEntity<List<String>>(service.getDepartmentNames(), HttpStatus.OK);
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<List<Department>> searchName(@PathVariable("name") String name) {
        return new ResponseEntity<List<Department>>(service.searchDepartments(name), HttpStatus.OK);
    }

    @GetMapping("/count")
    public ResponseEntity<List<String>> getEmployeeCount() {
        return new ResponseEntity<List<String>>(service.getEmployeeCount(), HttpStatus.OK);
    }

    @GetMapping("/view/{id}")
    public ResponseEntity<ViewDepartment> getDepartmentView (@PathVariable("id") String id) {
        return new ResponseEntity<ViewDepartment>(service.getDepartmentView(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Department> postDepartment(@RequestBody Department department) {
        return new ResponseEntity<Department>(service.addDepartment(department), HttpStatus.OK);
    }
    
}
