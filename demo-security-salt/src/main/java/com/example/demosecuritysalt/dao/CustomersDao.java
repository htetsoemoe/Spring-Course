package com.example.demosecuritysalt.dao;

import com.example.demosecuritysalt.ds.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomersDao extends CrudRepository<Customer, Integer> {
}
