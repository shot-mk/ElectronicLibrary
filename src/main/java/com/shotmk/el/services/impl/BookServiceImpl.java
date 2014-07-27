package com.shotmk.el.services.impl;


import com.shotmk.el.entity.Book;
import com.shotmk.el.entity.Tag;
import com.shotmk.el.repository.BookRepository;
import com.shotmk.el.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private static final int PAGE_SIZE = 4;

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

    public List<Book> findByName(String name) {
        return bookRepository.findByName(name);
    }


    @Override
    public List<Book> findByDescription(String description) {
        return bookRepository.findByDescription(description);
    }

    public Page<Book> getBookPage(Integer pageNumber) {
        PageRequest request =
                new PageRequest(pageNumber - 1, PAGE_SIZE);
        return bookRepository.findAll(request);
    }

    public List<Book> findBooksByTag(Tag tag) {
        List<Book> allBook = this.getBookList();
        List<Book> resultList = new ArrayList<>();
        for (Book book : allBook) {
            if (book.getTags().contains(tag)) {
                resultList.add(book);
            }
        }
        return resultList;
    }
}
