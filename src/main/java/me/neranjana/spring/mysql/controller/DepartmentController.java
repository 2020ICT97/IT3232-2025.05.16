package me.neranjana.spring.mysql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.neranjana.spring.mysql.models.Department;
import me.neranjana.spring.mysql.repo.DepartmentRepo;


@RestController
@RequestMapping("/departments")
public class DepartmentController {
    @Autowired
    private DepartmentRepo repo;

    @GetMapping("/test")
    public String myMessage() {
		return "Hello Spring Boot";
	}
    
    @GetMapping
    public List<Department> getDepartments() {
        try {
            return repo.findAll();
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return null;
    }
    
    @GetMapping("/{id}")
    public Department getMethodName(@PathVariable("id") String id) {
        return repo.findById(id).get();
    }
    
}
