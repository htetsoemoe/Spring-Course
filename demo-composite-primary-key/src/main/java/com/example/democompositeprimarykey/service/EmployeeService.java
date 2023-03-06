package com.example.democompositeprimarykey.service;

import com.example.democompositeprimarykey.dao.DepartmentDao;
import com.example.democompositeprimarykey.dao.EmployeesDao;
import com.example.democompositeprimarykey.entities.Department;
import com.example.democompositeprimarykey.entities.DepartmentId;
import com.example.democompositeprimarykey.entities.EmployeeId;
import com.example.democompositeprimarykey.entities.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeService {
    @Autowired
    private DepartmentDao departmentDao;
    @Autowired
    private EmployeesDao employeesDao;

    @Transactional
    public void createDb() {

        Department department1 = new Department("M102", "Mandalay", "Accounting");
        Department department2 = new Department("S102", "Mandalay", "Finance");


        Employees e1 = new Employees(new EmployeeId("mdy", "sbn123"), "LP", 500000);
        Employees e2 = new Employees(new EmployeeId("mdy", "sbn124"), "Ko Moe", 400000);
        Employees e3 = new Employees(new EmployeeId("mdy", "sbn125"), "Yan Lay", 300000);
        Employees e4 = new Employees(new EmployeeId("mdy", "sbn126"), "Hein Ko", 300000);

        //managed state and get primary key
        //Employees managedE1 = employeesDao.save(e1);

        Employees me1 = employeesDao.save(e1);//me1 is managed stage
        Employees me2 = employeesDao.save(e2);

        Employees me3 = employeesDao.save(e3);
        Employees me4 = employeesDao.save(e4);

        //department1.getEmployees().add(me1);
        department1.addEmployee(me1);
        me1.setDepartment(departmentDao.save(department1));

        department1.getEmployees().add(me2);
        me2.setDepartment(departmentDao.save(department1));

        department2.getEmployees().add(me3);
        me3.setDepartment(departmentDao.save(department2));

        department2.getEmployees().add(me4);
        me4.setDepartment(departmentDao.save(department2));

    }

    @Transactional
    public Department findDepartmentById(DepartmentId departmentId) {
        return departmentDao.findById(departmentId).get();
    }
}
