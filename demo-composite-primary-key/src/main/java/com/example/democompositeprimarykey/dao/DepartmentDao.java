package com.example.democompositeprimarykey.dao;

import com.example.democompositeprimarykey.entities.Department;
import com.example.democompositeprimarykey.entities.DepartmentId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentDao extends CrudRepository<Department, DepartmentId> {
}
