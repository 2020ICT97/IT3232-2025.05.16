package me.neranjana.spring.mysql.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Employee extends Person {
    @Id
    private String empNo;
    private double salary;
    @ManyToOne
    private Department department;
    @JsonIgnore
    @ManyToMany(mappedBy = "employees")
    private List<Project> projects;
    
    public Employee() {
    }

    public Employee(String empNo, String name, int age, double salary, String gender, Department department,
            List<Project> projects) {
        this.empNo = empNo;
        this.salary = salary;
        this.department = department;
        this.projects = projects;
    }

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
    
}
