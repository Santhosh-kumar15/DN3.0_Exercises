package com.bookapi.book_store_restful_api.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

public class CustomerDTO {
    private Long id;
    @JsonAlias("customer_name")
    private String name;
    private String email;
}
