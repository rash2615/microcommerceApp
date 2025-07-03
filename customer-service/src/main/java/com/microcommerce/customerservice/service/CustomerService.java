package com.microcommerce.customerservice.service;

import com.microcommerce.customerservice.model.Customer;
import com.microcommerce.customerservice.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository repo;

    public CustomerService(CustomerRepository repo) {
        this.repo = repo;
    }

    public List<Customer> getAll() {
        return repo.findAll();
    }

    public Customer getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Customer save(Customer customer) {
        return repo.save(customer);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
