package com.bookapi.book_store_restful_api;

import com.bookapi.book_store_restful_api.entity.Book;
import com.bookapi.book_store_restful_api.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class BookControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BookRepository bookRepository;

    @BeforeEach
    void setUp() {
        // Clean up database before each test
        bookRepository.deleteAll();
    }

    @Test
    void testCreateBook() throws Exception {
        String bookJson = "{\"title\":\"New Book\",\"author\":\"New Author\",\"price\":20.0,\"isbn\":\"67890\"}";

        mockMvc.perform(post("/books")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(bookJson))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.title").value("New Book"));
    }

    @Test
    void testGetBookById() throws Exception {
        Book book = new Book(null, "Book Title", "Author", 10.0, "12345");
        Book savedBook = bookRepository.save(book);

        mockMvc.perform(get("/books/{id}", savedBook.getId()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.title").value("Book Title"));
    }

    @Test
    void testUpdateBook() throws Exception {
        Book book = new Book(null, "Book Title", "Author", 10.0, "12345");
        Book savedBook = bookRepository.save(book);

        String updatedBookJson = "{\"title\":\"Updated Book\",\"author\":\"Updated Author\",\"price\":25.0,\"isbn\":\"54321\"}";

        mockMvc.perform(put("/books/{id}", savedBook.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(updatedBookJson))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.title").value("Updated Book"));
    }

    @Test
    void testDeleteBook() throws Exception {
        Book book = new Book(null, "Book Title", "Author", 10.0, "12345");
        Book savedBook = bookRepository.save(book);

        mockMvc.perform(delete("/books/{id}", savedBook.getId()))
                .andExpect(status().isNoContent());
    }
}
