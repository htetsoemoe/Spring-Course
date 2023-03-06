package com.example.demosecuritysalt.dao;

import com.example.demosecuritysalt.ds.Department;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentsDao extends CrudRepository<Department, Integer> {
}
