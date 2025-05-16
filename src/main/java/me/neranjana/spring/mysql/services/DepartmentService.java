package me.neranjana.spring.mysql.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import me.neranjana.spring.mysql.models.Department;
import me.neranjana.spring.mysql.repo.DepartmentRepo;

public class DepartmentService {
    @Autowired
    private DepartmentRepo repo;

    public List<Department> getDepartments() {
        return repo.findAll();

    }

    public Department getDepartmentById(String id) {
        return repo.findById(id).get();
    }

    public String postDepartment(Department department) {
        repo.save(department);

        return "New department added";
    }

    public String putDepartment(String id, Department department) {
        if (repo.findById(id).isEmpty()) {
            return "Department not found!";
        }

        repo.save(department);
        return "Department updated!";
    }

    public String deleteDepartment(String id) {
        if (repo.findById(id).isEmpty()) {
            return "Department not found!";
        }

        repo.deleteById(id);
        return "Department deleted!";
    }
}
