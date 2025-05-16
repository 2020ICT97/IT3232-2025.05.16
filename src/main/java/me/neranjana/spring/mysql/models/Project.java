package me.neranjana.spring.mysql.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Project {
    @Id
    private String projectId;
    @Column(nullable = false)
    private String name;
    private long totalCost;
    @ManyToMany
    @JoinTable(name = "project_assignments",
            joinColumns = @JoinColumn(name = "pro_id"),
            inverseJoinColumns = @JoinColumn(name = "emp_id"))
    private List<Employee> employees;
    
    public Project() {
    }

    public Project(String projectId, String name, long totalCost, List<Employee> employees) {
        this.projectId = projectId;
        this.name = name;
        this.totalCost = totalCost;
        this.employees = employees;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public long getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(long totalCost) {
        this.totalCost = totalCost;
    }
}
