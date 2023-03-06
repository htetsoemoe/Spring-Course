package com.example.demoresponsestatus.controller;


import com.example.demoresponsestatus.ds.Customer;
import com.example.demoresponsestatus.exception.CustomBadRequestException;
import com.example.demoresponsestatus.exception.CustomBandwidthLimitException;
import com.example.demoresponsestatus.exception.CustomPaymentRequiredException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomersControllerV1 {

    @GetMapping("/api/v1/customerA")
    public Customer getCustomerA() {
        throw new CustomBadRequestException();
    }

    @GetMapping("/api/v1/customerB")
    public Customer getCustomerB() {
        throw new CustomPaymentRequiredException();
    }

    @GetMapping("/api/v1/customerC")
    public Customer getCustomerC() {
        throw new CustomBandwidthLimitException();
    }
}

// curl -i http://localhost:8080/api/v1/customerA

// curl -i http://localhost:8080/api/v1/customerB

// curl -i http://localhost:8080/api/v1/customerC