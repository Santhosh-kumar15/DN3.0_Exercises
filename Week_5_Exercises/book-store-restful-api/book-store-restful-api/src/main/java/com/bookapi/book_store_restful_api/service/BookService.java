package com.bookapi.book_store_restful_api.service;

import com.bookapi.book_store_restful_api.entity.Book;
import com.bookapi.book_store_restful_api.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> findBookById(Long id) {
        return bookRepository.findById(id);
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    public Book updateBook(Long id, Book updatedBook) {
        Optional<Book> existingBookOpt = bookRepository.findById(id);
        if (existingBookOpt.isPresent()) {
            Book existingBook = existingBookOpt.get();
            // Update fields
            existingBook.setTitle(updatedBook.getTitle());
            existingBook.setAuthor(updatedBook.getAuthor());
            existingBook.setPrice(updatedBook.getPrice());
            // Update any other fields as necessary

            return bookRepository.save(existingBook);
        } else {
            // Handle the case where the book is not found
            throw new RuntimeException("Book not found with id " + id);
        }
    }
}
