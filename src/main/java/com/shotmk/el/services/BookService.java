package com.shotmk.el.services;

import com.shotmk.el.entity.Book;

import java.util.List;

public interface BookService {

    public Book addBook(Book book);

    public List<Book> getBookList();

    public Book getBook(int id);

    public void deleteBook(Book book);

}
