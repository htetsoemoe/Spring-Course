package com.example.demosecuritysalt.dao;

import com.example.demosecuritysalt.ds.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeesDao extends CrudRepository<Employee, Integer> {
}
