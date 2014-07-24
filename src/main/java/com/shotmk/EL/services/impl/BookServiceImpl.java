package com.shotmk.EL.services.impl;


import com.shotmk.EL.entity.Book;
import com.shotmk.EL.repository.BookRepository;
import com.shotmk.EL.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


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
}
