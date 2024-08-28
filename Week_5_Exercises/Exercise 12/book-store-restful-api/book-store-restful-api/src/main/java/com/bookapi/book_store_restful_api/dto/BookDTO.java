package com.bookapi.book_store_restful_api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BookDTO {
    @JsonProperty("book_id")
    private Long id;
    @JsonProperty("book_title")
    private String title;
    private String author;
    private Double price;
    private String isbn;
}
