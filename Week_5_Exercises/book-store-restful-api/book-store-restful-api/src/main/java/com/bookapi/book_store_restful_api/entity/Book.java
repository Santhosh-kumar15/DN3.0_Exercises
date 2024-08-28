package com.bookapi.book_store_restful_api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private double price;
    private String isbn;
    @Version
    private int version;
    // Default constructor

//    public Book(Long id, String title, String author, double price, String isbn, int version) {
//        this.id = id;
//        this.title = title;
//        this.author = author;
//        this.price = price;
//        this.isbn = isbn;
//        this.version = version;
//    }

    public Book(Object o, String bookTitle, String author, double v, String number) {
    }


    // Parameterized constructor
    

}
