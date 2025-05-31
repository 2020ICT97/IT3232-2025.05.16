package me.neranjana.spring.mysql.models;

import java.util.Date;
import java.util.List;

public class ViewDepartment extends Department {
    private int employeeCount;

    public ViewDepartment() {
        
    }
    
    public ViewDepartment(int employeeCount) {
        this.employeeCount = employeeCount;
    }
    
    public ViewDepartment(String depId, String name, Date established, List<Employee> employees, int employeeCount) {
        super(depId, name, established, employees);
        this.employeeCount = employeeCount;
    }
}
