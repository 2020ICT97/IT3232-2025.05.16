package me.neranjana.spring.mysql.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import me.neranjana.spring.mysql.models.Department;
import me.neranjana.spring.mysql.models.ViewDepartment;
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

    public List<String> getDepartmentNames() {
        if(repo.getDeptNames().isEmpty()) {
            throw new EntityNotFoundException("No departments Found!");
        }

        return repo.getDeptNames();
    }

    public List<String> getEmployeeCount() {
        if(repo.getEmployeeCount().isEmpty()) {
            throw new EntityNotFoundException("No departments Found!");
        }

        return repo.getEmployeeCount();
    }

    public int countEmployees(String id) {
        if(repo.countEmployees(id) == 0) {
            throw new EntityNotFoundException("No employees Found!");
        }

        return repo.countEmployees(id);
    }

    public ViewDepartment getDepartmentView(String id) {
        if(repo.findById(id) == null) {
            throw new EntityNotFoundException("Department Not Found!");
        }

        Department dept = repo.findById(id).get();
        ViewDepartment viewDepartment = new ViewDepartment(
                dept.getDepId(),dept.getName(), dept.getEstablished(), dept.getEmployees(), countEmployees(id)
            );

        return viewDepartment;
    }

    public List<Department> searchDepartments(String name) {
        if(repo.searchName(name).isEmpty()) {
            throw new EntityNotFoundException("No departments Found!");
        }

        return repo.searchName(name);
    }

    public Department addDepartment(Department department) {
        if(repo.findById(department.getDepId()).isPresent()) {
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
