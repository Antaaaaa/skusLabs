package com.example.skus.demo.laba4.service;

import com.example.skus.demo.laba4.model.Book;
import com.example.skus.demo.laba4.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Transactional(readOnly = true)
    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }
    @Transactional(readOnly = true)
    public List<Book> findAllByYearGreaterThenTen(Short year) {
        return bookRepository.findAllByYearBefore((short)(year-10));
    }
    @Transactional
    public void addNewBook(Book book) {
        bookRepository.save(book);
    }
    @Transactional
    public void removeBookById(Long id) {
        bookRepository.deleteById(id);
    }
}
