package com.example.demospringsecuritymodel.dao;

import com.example.demospringsecuritymodel.entities.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeesDao extends CrudRepository<Employee, Integer> {
}
