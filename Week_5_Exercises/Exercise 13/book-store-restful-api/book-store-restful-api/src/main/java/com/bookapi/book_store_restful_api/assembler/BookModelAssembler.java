package com.bookapi.book_store_restful_api.assembler;

import com.bookapi.book_store_restful_api.controller.BookController;
import com.bookapi.book_store_restful_api.entity.Book;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class BookModelAssembler implements RepresentationModelAssembler<Book, EntityModel<Book>> {

    @Override
    public EntityModel<Book> toModel(Book book) {
        return EntityModel.of(book,
                linkTo(methodOn(BookController.class).getBookById(book.getId())).withSelfRel(),
                linkTo(methodOn(BookController.class).getAllBooks()).withRel("books"));
    }
}
