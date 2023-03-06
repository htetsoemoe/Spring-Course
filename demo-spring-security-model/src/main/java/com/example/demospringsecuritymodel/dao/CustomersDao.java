package com.example.demospringsecuritymodel.dao;

import com.example.demospringsecuritymodel.entities.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomersDao extends CrudRepository<Customer, Integer> {
}
