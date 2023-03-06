package com.example.democompositeprimarykey.entities;

import lombok.Data;

import java.io.Serializable;

@Data
public class DepartmentId implements Serializable {



    private String departmentCode;
    private String departmentBranch;

    public DepartmentId() {

    }

    public DepartmentId(String departmentCode, String departmentBranch) {
        this.departmentCode = departmentCode;
        this.departmentBranch = departmentBranch;
    }
}
