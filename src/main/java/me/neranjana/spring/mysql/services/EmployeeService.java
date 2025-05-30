package me.neranjana.spring.mysql.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import me.neranjana.spring.mysql.models.Employee;
import me.neranjana.spring.mysql.repo.EmployeeRepo;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo repo;

    public List<Employee> getEmployeesInSalaryRange() {
        if(repo.getEmployeesInSalaryRange().isEmpty()) {
            throw new EntityNotFoundException("No employees Found!");
        }

        return repo.getEmployeesInSalaryRange();
    }

    public List<Employee> getEmployeesByDepartment(String id) {
        if(repo.getEmployeesByDepartment(id).isEmpty()) {
            throw new EntityNotFoundException("No employees Found!");
        }

        return repo.getEmployeesByDepartment(id);
    }

    public Employee getYoungestFemaleEmployee(){
        if(repo.getYoungestFemaleEmployee() == null) {
            throw new EntityNotFoundException("No employees Found!");
        }

        return repo.getYoungestFemaleEmployee();
    }
}
