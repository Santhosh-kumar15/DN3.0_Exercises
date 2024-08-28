package com.bookapi.book_store_restful_api.repository;

import com.bookapi.book_store_restful_api.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
