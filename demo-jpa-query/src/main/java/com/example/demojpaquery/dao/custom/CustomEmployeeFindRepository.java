package com.example.demojpaquery.dao.custom;

import com.example.demojpaquery.ds.Employee;

public interface CustomEmployeeFindRepository {

    Employee findByFirstNameAndLastName(String firstName, String lastName);
}
