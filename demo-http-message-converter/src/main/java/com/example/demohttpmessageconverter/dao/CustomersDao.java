package com.example.demohttpmessageconverter.dao;

import com.example.demohttpmessageconverter.ds.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomersDao extends CrudRepository<Customer, Integer> {
}
