package com.eindproject.v4.service;

import com.eindproject.v4.exceptions.RecordNotFoundException;
import com.eindproject.v4.model.Customer;
import com.eindproject.v4.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    //METHODS

    //GET
    public Collection<Customer> getCustomers() {
        return customerRepository.findAll();
    }


    public Optional<Customer> getCustomerById(long id) {
        try {
            Optional<Customer> customer = customerRepository.findById(id);
            return customer;
        } catch(Exception ex) {
            throw new RecordNotFoundException("Customer does not exist");
        }
    }

    //POST
    public long createCustomer(Customer customer) {
        Customer newCustomer = (Customer) customerRepository.save(customer);
        return newCustomer.getId();
    }

    public void addNewCustomer(Customer customer) {
        Optional<Customer> customerOptional = customerRepository
                .findCustomerByEmail(customer.getEmail());
        if(customerOptional.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        customerRepository.save(customer);
    }


    public void updateCustomer(long id, Customer customer) {
        try {
            Customer existingCustomer = (Customer) customerRepository.findById(id).get();
            existingCustomer.setFirstName(customer.getFirstName());
            existingCustomer.setLastName(customer.getLastName());
            existingCustomer.setEmail(customer.getEmail());
            customerRepository.save(existingCustomer);
        } catch(Exception ex) {
            throw new RecordNotFoundException("Customer does not exist");
        }
    }

//    @Transactional //automatically update entity with setters if possible without needing the queries
//    public void updateCustomer2(Long customerId,
//                                String name,
//                                String email) throws Throwable {
//        Customer customer = (Customer) customerRepository.findById(customerId)
//                .orElseThrow(() -> new IllegalStateException(
//                        "customer with id" + customerId + "does not exist"
//                ));
//
//        if(name != null &&
//                name.length() > 0 &&
//                !Objects.equals(customer.getFirstName(), name)) {
//            customer.setFirstName(name);
//        }
//
//        if (email != null &&
//                email.length() > 0 &&
//                !Objects.equals(customer.getEmail(), email)) {
//            Optional<Customer> customerOptional = customerRepository
//                    .findCustomerByEmail(email);
//            if(customerOptional.isPresent()) {
//                throw new IllegalStateException("This email is already taken");
//            }
//            customer.setEmail(email);
//        }
//    }


    //DELETE
    public void deleteCustomerById(long id) {
        try {
            customerRepository.deleteById(id);
        } catch(Exception ex) {
            throw new RecordNotFoundException("Customer does not exist");
        }
    }




}
