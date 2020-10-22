package com.example.skus.demo.laba4.repository;

import com.example.skus.demo.laba4.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findAllByYearBefore(Short year);
}
