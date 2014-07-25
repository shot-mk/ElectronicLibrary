package com.shotmk.el.services.impl;


import com.shotmk.el.entity.Book;
import com.shotmk.el.repository.BookRepository;
import com.shotmk.el.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override

    public Book addBook(Book book) {
        Book savedBook = bookRepository.saveAndFlush(book);
        return savedBook;
    }

    @Override

    public List<Book> getBookList() {
        return bookRepository.findAll();
    }

    @Override

    public Book getBook(int id) {
        return bookRepository.findOne(id);
    }

    @Override

    public void deleteBook(Book book) {
        bookRepository.delete(book);
    }

    @Override

    public Book findByName(String name) {
        return bookRepository.findByName(name);
    }

}
