package com.bookapi.book_store_restful_api.mapper;

import com.bookapi.book_store_restful_api.dto.CustomerDTO;
import com.bookapi.book_store_restful_api.entity.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface CustomerMapper {
    CustomerDTO toDTO(Customer customer);
    Customer toEntity(CustomerDTO customerDTO);
}
