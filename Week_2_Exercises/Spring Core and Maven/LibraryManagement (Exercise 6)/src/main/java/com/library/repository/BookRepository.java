package com.library.repository;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {
    public void someDatabaseOperation(){
        System.out.println("Performing database operation in BookRepository..");
    }
}
