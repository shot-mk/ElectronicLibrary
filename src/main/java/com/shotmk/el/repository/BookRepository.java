package com.shotmk.el.repository;

import com.shotmk.el.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BookRepository extends JpaRepository<Book, Integer> {

    @Query("select b from Book b where b.name = :name")
    Book findByName(@Param("name") String name);

}
