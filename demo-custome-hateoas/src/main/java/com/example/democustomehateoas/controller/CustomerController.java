package com.example.democustomehateoas.controller;

import com.example.democustomehateoas.dao.AddressDao;
import com.example.democustomehateoas.dao.CustomerDao;
import com.example.democustomehateoas.ds.Address;
import com.example.democustomehateoas.ds.Customer;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@RestController
public class CustomerController {


    public static final Class<CustomerController> CONTROLLER_CLASS = CustomerController.class;

    private final CustomerDao customerDao;

    private final AddressDao addressDao;

    public CustomerController(CustomerDao customerDao, AddressDao addressDao) {
        this.customerDao = customerDao;
        this.addressDao = addressDao;
    }

    @GetMapping("/customers/{id}")
    public EntityModel<Customer> getCustomer(@PathVariable int id) {
        Optional<Customer> customer = customerDao.findById(id);
        if (!customer.isPresent()) {
            throw new EntityNotFoundException("id - " + id);
        }

        EntityModel<Customer> resource = EntityModel.of(customer.get());
        resource.add(linkTo(methodOn(CONTROLLER_CLASS).getCustomer(id)).withSelfRel());
        resource.add(linkTo(methodOn(CONTROLLER_CLASS).listAddresses(id)).withRel("addresses"));
        resource.add(linkTo(methodOn(CONTROLLER_CLASS).getCustomer(id)).withRel("customer"));
        resource.add(linkTo(methodOn(CONTROLLER_CLASS).listCustomers()).withRel("customers"));
        return resource;
    }


    @GetMapping("/customers")
    public CollectionModel<EntityModel<Customer>> listCustomers() {
        List<EntityModel<Customer>> customerEntityModel =
                StreamSupport.stream(customerDao.findAll().spliterator(), false)
                        .map(customer -> EntityModel.of(customer, linkTo(methodOn(CONTROLLER_CLASS).getCustomer(customer.getId())).withSelfRel(),
                                linkTo(methodOn(CONTROLLER_CLASS).getCustomer(customer.getId())).withRel("customer")
                                ))
                        .collect(Collectors.toList());

        Link customersLink = linkTo(methodOn(CONTROLLER_CLASS).listCustomers()).withSelfRel();
        return CollectionModel.of(customerEntityModel, customersLink);
    }

    // Helper Method public EntityModel<Customer> getCustomer(@PathVariable int id)
    @GetMapping("/customers/{customerId}/addresses")
    public CollectionModel<EntityModel<Address>> listAddresses(@PathVariable int customerId) {
        Customer customer = customerDao.findById(customerId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));


        List<EntityModel<Address>> addressesEntityModel = customer.getAddresses()
                .stream()
                .map(address -> EntityModel.of(address,
                        linkTo(methodOn(CONTROLLER_CLASS).getAddress(customerId, address.getId())).withSelfRel(),
                        linkTo(methodOn(CONTROLLER_CLASS).getCustomer(address.getCustomer().getId())).withRel("customer")))
                .collect(Collectors.toList());

        return CollectionModel.of(addressesEntityModel);

    }


    // Helper Method for public EntityModel<Address> getAddress(@PathVariable int customerId, @PathVariable int addressId)
    private Customer getCustomerById(int customerId) {
        return customerDao.findById(customerId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }


    @GetMapping("/customers/{customerId}/addresses/{addressId}")
    public EntityModel<Address> getAddress(@PathVariable int customerId, @PathVariable int addressId) {
        Customer customer = getCustomerById(customerId);

        Address customerAddress = customer.getAddresses()
                .stream()
                .filter(address -> address.getId().equals(addressId))
                .findAny()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        return EntityModel.of(customerAddress, linkTo(methodOn(CONTROLLER_CLASS).getAddress(customerId, addressId))
                .withSelfRel(), linkTo(methodOn(CONTROLLER_CLASS).getCustomer(customerId)).withRel("customer"));
    }

}
