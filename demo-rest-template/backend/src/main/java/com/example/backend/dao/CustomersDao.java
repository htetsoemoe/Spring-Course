package com.example.backend.dao;

import com.example.backend.ds.Customer;
import com.example.backend.ds.Customers;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomersDao extends CrudRepository<Customer, Integer> {
}
