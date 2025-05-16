package me.neranjana.spring.mysql.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.neranjana.spring.mysql.models.Department;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, String> {
    
}
