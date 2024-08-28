package com.bookapi.book_store_restful_api.controller;

import com.bookapi.book_store_restful_api.entity.Book;
import com.bookapi.book_store_restful_api.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@RequestMapping("/books")
@Tag(name = "Books", description = "API for managing books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    @Operation(summary = "Get all books", description = "Retrieve a list of all books")
    public List<Book> getAllBooks() {
        return bookService.findAllBooks();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a book by ID", description = "Retrieve a book by its ID")
    public ResponseEntity<Book> getBookById(
            @PathVariable @Parameter(description = "ID of the book to retrieve") Long id) {
        return bookService.findBookById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Add a new book", description = "Add a new book to the inventory")
    public ResponseEntity<Book> addBook(
            @RequestBody @Parameter(description = "Details of the book to add") Book book) {
        return ResponseEntity.ok(bookService.saveBook(book));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a book", description = "Update the details of an existing book")
    public ResponseEntity<Book> updateBook(
            @PathVariable @Parameter(description = "ID of the book to update") Long id,
            @RequestBody @Parameter(description = "Updated details of the book") Book book) {
        return ResponseEntity.ok(bookService.updateBook(id, book));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a book", description = "Delete a book by its ID")
    public ResponseEntity<Void> deleteBook(
            @PathVariable @Parameter(description = "ID of the book to delete") Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }
}
