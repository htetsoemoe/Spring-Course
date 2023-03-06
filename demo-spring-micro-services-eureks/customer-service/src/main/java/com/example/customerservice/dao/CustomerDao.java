package com.example.customerservice.dao;

import com.example.customerservice.ds.Customer;
import org.springframework.data.repository.CrudRepository;


public interface CustomerDao extends CrudRepository<Customer, Integer> {
}
