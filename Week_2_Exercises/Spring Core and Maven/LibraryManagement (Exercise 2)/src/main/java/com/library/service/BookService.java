package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void performSomeOperation() {
        System.out.println("Performing operation in BookService...");
        bookRepository.someDatabaseOperation();
    }
}
