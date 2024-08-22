package com.bsapi.BookstoreApi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


public class BookDTO {
    @JsonProperty("book_id")
    private Long id;
    @JsonProperty("book_title")
    private String title;
    private String author;
    private Double price;
    private String isbn;
}
