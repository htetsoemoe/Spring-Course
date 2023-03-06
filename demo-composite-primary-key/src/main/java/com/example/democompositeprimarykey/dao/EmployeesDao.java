package com.example.democompositeprimarykey.dao;

import com.example.democompositeprimarykey.entities.EmployeeId;
import com.example.democompositeprimarykey.entities.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeesDao extends JpaRepository<Employees, EmployeeId> {
}
