package com.bookapi.book_store_restful_api.controller;

import com.bookapi.book_store_restful_api.assembler.CustomerModelAssembler;
import com.bookapi.book_store_restful_api.entity.Customer;
import com.bookapi.book_store_restful_api.repository.CustomerRepository;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerRepository customerRepository;
    private final CustomerModelAssembler assembler;

    public CustomerController(CustomerRepository customerRepository, CustomerModelAssembler assembler) {
        this.customerRepository = customerRepository;
        this.assembler = assembler;
    }

    @GetMapping("/{id}")
    public EntityModel<Customer> getCustomerById(@PathVariable Long id) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Customer not found"));
        return assembler.toModel(customer);
    }

    @GetMapping
    public CollectionModel<EntityModel<Customer>> getAllCustomers() {
        List<EntityModel<Customer>> customers = customerRepository.findAll().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(customers, linkTo(methodOn(CustomerController.class).getAllCustomers()).withSelfRel());
    }
}
