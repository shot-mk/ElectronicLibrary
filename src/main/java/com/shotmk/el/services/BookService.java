package com.shotmk.el.services;

import com.shotmk.el.entity.Book;
import com.shotmk.el.entity.Tag;
import org.springframework.data.domain.Page;

import java.util.List;

public interface BookService {

    public Book addBook(Book book);

    public List<Book> getBookList();

    public Book getBook(int id);

    public void deleteBook(Book book);

    public List<Book> findByName(String name);

    public List<Book> findByDescription(String description);

    public Page<Book> getBookPage(Integer pageNumber);

    public List<Book> findBooksByTag(Tag tag);


}
