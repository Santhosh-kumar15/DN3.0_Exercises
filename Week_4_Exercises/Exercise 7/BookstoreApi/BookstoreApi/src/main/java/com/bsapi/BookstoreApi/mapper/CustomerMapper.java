package com.bsapi.BookstoreApi.mapper;

import com.bsapi.BookstoreApi.dto.CustomerDTO;
import com.bsapi.BookstoreApi.entity.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerDTO toDTO(Customer customer);
    Customer toEntity(CustomerDTO customerDTO);
}
