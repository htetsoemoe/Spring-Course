package com.example.demospringrest1.controller;

import com.example.demospringrest1.dao.CustomerDao;
import com.example.demospringrest1.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;
import java.util.stream.Collectors;

@RestController
public class CustomersController {

    @Autowired
    private CustomerDao customerDao;

    @GetMapping("/customers")
    public Iterable<Customer> list() {
        return customerDao.findAll();
    }

    @GetMapping("/customers/{id}")
    public Customer get(@PathVariable("id") int id) {
        return customerDao.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/customers")
    public ResponseEntity<Customer> create(@RequestBody Customer customer, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            Customer savedCustomer = customerDao.save(customer);

            return ResponseEntity
                    .created(URI.create("/customers/" + savedCustomer.getId())) //Create a new builder with a CREATED status and a location header set to the given URI.
                                                                                // CREATED -> public static final HttpStatus CREATED    201 Created.
                    .body(savedCustomer);//Set the media type of the body, as specified by the Content-Type header.
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format("Request contains incorrect data [%s]",
                    getErrors(bindingResult)));
        }
    }

    @PutMapping("/customers/{id}")
    public ResponseEntity<Customer> update(@RequestBody Customer customer, @PathVariable int id, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {

            if (customerDao.existsById(id)) {
                customer.setId(id);
                Customer savedCustomer = customerDao.save(customer);

                return ResponseEntity
                        .ok(savedCustomer);
            } else {
                return ResponseEntity.notFound().build();
            }

        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format("Request contains incorrect data = [%s]",
                    getErrors(bindingResult)));
        }
    }

    @DeleteMapping("/customers/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        if (customerDao.existsById(id)) {
            customerDao.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    private String getErrors(BindingResult bindingResult) {
        return bindingResult.getAllErrors().stream()
                .map(ObjectError::getDefaultMessage)
                .collect(Collectors.joining(", "));
    }
}
