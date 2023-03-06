package com.example.democompositeprimarykey.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
public class Employees {
    @EmbeddedId
    private EmployeeId employeeId;

    private String name;
    private double salary;

    @ManyToOne
    private Department department;

    public Employees() {
    }

    public Employees(EmployeeId employeeId, String name, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.salary = salary;
    }
}
