package com.bsapi.BookstoreApi.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

public class CustomerDTO {
    private Long id;
    @JsonAlias("customer_name")
    private String name;
    private String email;
}
