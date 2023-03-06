package com.example.demospringsecuritymodel.dao;

import com.example.demospringsecuritymodel.entities.Department;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentsDao extends CrudRepository<Department, Integer> {
}
