package com.bsapi.BookstoreApi.controller;

import com.bsapi.BookstoreApi.entity.Book;
import com.bsapi.BookstoreApi.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/books")
public class BookController {

    private Map<Long, Book> bookStore = new HashMap<>();
    private long currentId = 1;

    @GetMapping("/all")
    public List<Book> getAllBooks() {
        return new ArrayList<>(bookStore.values());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        Book book = Optional.ofNullable(bookStore.get(id))
                .orElseThrow(() -> new ResourceNotFoundException("Book not found"));

        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "Book Retrieved");

        return new ResponseEntity<>(book, headers, HttpStatus.OK);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        book.setId(currentId++);
        bookStore.put(book.getId(), book);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "Book Created");

        return new ResponseEntity<>(book, headers, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book updatedBook) {
        if (!bookStore.containsKey(id)) {
            throw new ResourceNotFoundException("Book not found");
        }
        updatedBook.setId(id);
        bookStore.put(id, updatedBook);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "Book Updated");

        return new ResponseEntity<>(updatedBook, headers, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        if (!bookStore.containsKey(id)) {
            throw new ResourceNotFoundException("Book not found");
        }
        bookStore.remove(id);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "Book Deleted");

        return new ResponseEntity<>(headers, HttpStatus.NO_CONTENT);
    }


    @GetMapping("/search")
    public List<Book> searchBooks(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String author) {
        return bookStore.values().stream()
                .filter(book -> (title == null || book.getTitle().contains(title)))
                .filter(book -> (author == null || book.getAuthor().contains(author)))
                .collect(Collectors.toList());
    }




}
