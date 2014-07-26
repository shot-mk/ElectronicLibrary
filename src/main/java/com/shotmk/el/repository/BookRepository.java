package com.shotmk.el.repository;

import com.shotmk.el.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

    @Query("select b from Book b where b.name like %:name%")
    List<Book> findByName(@Param("name") String name);

    @Query("select b from Book b where b.description like %:description%")
    List<Book> findByDescription(@Param("description") String description);


}
