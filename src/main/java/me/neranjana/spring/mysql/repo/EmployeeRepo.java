package me.neranjana.spring.mysql.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import me.neranjana.spring.mysql.models.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, String> {
    @Query("SELECT e FROM Employee AS e WHERE e.salary > 70000 AND e.salary < 90000")
    public List<Employee> getEmployeesInSalaryRange();

    @Query("SELECT e FROM Employee AS e WHERE e.department.deptId = ?1")
    public List<Employee> getEmployeesByDepartment(String id);

    @Query(value = "SELECT e FROM Employee AS e WHERE e.gender = female ORDER BY e.age DESC LIMIT 1", nativeQuery = true)
    public Employee getYoungestFemaleEmployee();
}
