package com.bsapi.BookstoreApi.controller;

import com.bsapi.BookstoreApi.entity.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private Map<Long, Customer> customerStore = new HashMap<>();
    private AtomicLong idCounter = new AtomicLong();

    // Endpoint to handle JSON request bodies
    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        customer.setId(idCounter.incrementAndGet());
        customerStore.put(customer.getId(), customer);
        return customer;
    }

    // Endpoint to handle form data
    @PostMapping("/register")
    public Customer registerCustomer(
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("address") String address) {
        Customer customer = new Customer();
        customer.setId(idCounter.incrementAndGet());
        customer.setName(name);
        customer.setEmail(email);
        customer.setAddress(address);
        customerStore.put(customer.getId(), customer);
        return customer;
    }
}
