package com.bookapi.book_store_restful_api.mapper;

import com.bookapi.book_store_restful_api.dto.BookDTO;
import com.bookapi.book_store_restful_api.entity.Book;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {
    BookDTO toDTO(Book book);
    Book toEntity(BookDTO bookDTO);
}
