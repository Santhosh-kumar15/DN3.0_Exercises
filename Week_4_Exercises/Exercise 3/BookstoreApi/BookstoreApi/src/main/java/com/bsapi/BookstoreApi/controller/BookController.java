package com.bsapi.BookstoreApi.controller;

import com.bsapi.BookstoreApi.entity.Book;
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
    public Book getBookById(@PathVariable Long id) {
        return bookStore.get(id);
    }

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        book.setId(currentId++);
        bookStore.put(book.getId(), book);
        return book;
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book updatedBook) {
        if (bookStore.containsKey(id)) {
            updatedBook.setId(id);
            bookStore.put(id, updatedBook);
            return updatedBook;
        } else {
            throw new RuntimeException("Book not found with id " + id);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookStore.remove(id);
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
