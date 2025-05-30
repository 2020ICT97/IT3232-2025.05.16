package me.neranjana.spring.mysql.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import me.neranjana.spring.mysql.models.Department;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, String> {
    @Query("SELECT name FROM Department")
    public List<String> getDeptNames();

    @Query("SELECT d FROM Department AS d WHERE d.name LIKE %?1%")
    public List<Department> searchName(String name);
}
