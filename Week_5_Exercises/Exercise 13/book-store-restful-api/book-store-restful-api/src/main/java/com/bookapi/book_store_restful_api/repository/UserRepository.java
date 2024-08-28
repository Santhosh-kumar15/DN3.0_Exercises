package com.bookapi.book_store_restful_api.repository;

import com.bookapi.book_store_restful_api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

}
