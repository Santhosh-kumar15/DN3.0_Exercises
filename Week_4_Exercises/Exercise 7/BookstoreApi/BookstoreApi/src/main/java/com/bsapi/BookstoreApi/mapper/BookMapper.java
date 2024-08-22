package com.bsapi.BookstoreApi.mapper;

import com.bsapi.BookstoreApi.dto.BookDTO;
import com.bsapi.BookstoreApi.entity.Book;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {
    BookDTO toDTO(Book book);
    Book toEntity(BookDTO bookDTO);
}
