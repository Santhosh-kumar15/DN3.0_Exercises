package com.bsapi.BookstoreApi.controller;

import com.bsapi.BookstoreApi.entity.Book;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/books")
public class BookController {
    private Map<Long, Book> bookStore = new HashMap<>();
    private long currentId = 1;

    @GetMapping
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
}
