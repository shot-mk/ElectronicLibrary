package com.shotmk.el.repository;

import com.shotmk.el.entity.Rate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RateRepository extends JpaRepository<Rate, Integer> {

    @Query("select r from Rate r where r.user.login = :userid and r.book.id = :bookid ")
    Rate getExistRate(@Param("userid") String userid, @Param("bookid") int id);

}
