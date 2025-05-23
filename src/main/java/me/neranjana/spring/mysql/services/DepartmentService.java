package me.neranjana.spring.mysql.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import me.neranjana.spring.mysql.models.Department;
import me.neranjana.spring.mysql.repo.DepartmentRepo;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepo repo;

    public List<Department> getDepartments() {
        return repo.findAll();

    }

    public Department getDepartmentById(String id) {
        if(repo.findById(id).isEmpty()) {
            throw new EntityNotFoundException("Department Not Found!");
        }

        return repo.findById(id).get();
    }

    public Department addDepartment(Department department) {
        if(repo.findById(department.getDepId()).isPresent()) {
            // System.out.println("Department with the same ID exists!");

            throw new DuplicateKeyException("Department with the same ID exists!");
        }

        repo.save(department);

        return department;
    }

    public String updateDepartment(String id, Department department) {
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
