package com.shotmk.EL.repository;

import com.shotmk.EL.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
