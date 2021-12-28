package com.eindproject.v4.controllers;

import com.eindproject.v4.model.Customer;
import com.eindproject.v4.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    //GET
    @GetMapping("/customers")
    public ResponseEntity getCustomers() {
        return ResponseEntity.ok().body(customerService.getCustomers());
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity getCustomerById(@PathVariable long id) {
        return ResponseEntity.ok().body(customerService.getCustomerById(id));
    }


    //POST
    @PostMapping("/customers")
    public ResponseEntity addCustomer(@RequestBody Customer customer) { //req body om info door te geven
        long newId = customerService.createCustomer(customer);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newId).toUri();

        return ResponseEntity.created(location).body(location);
    }

    @PostMapping("/placeholder")
    public void registerNewCustomer(@RequestBody Customer customer) {
        customerService.addNewCustomer(customer);
    }


    //PUT
    @PutMapping("/customers/{id}")
    public ResponseEntity updateCustomer(@PathVariable long id, @RequestBody Customer customer) {
        customerService.updateCustomer(id, customer);
        return ResponseEntity.ok("Customer updated");
    }

//    @PutMapping("/customers/{id}")
//    public void updateCustomer2(
//            @PathVariable("customerId") Long customerId,
//            @RequestParam(required = false) String name,
//            @RequestParam(required = false) String email) {
//        customerService.updateCustomer2(customerId, name, email);
//    }


    //DELETE
    public ResponseEntity deleteCustomer(@PathVariable long id) {
        customerService.deleteCustomerById(id);
        return ResponseEntity.ok("Customer deleted");
    }
}
