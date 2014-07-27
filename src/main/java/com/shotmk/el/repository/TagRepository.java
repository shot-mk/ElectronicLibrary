package com.shotmk.el.repository;

import com.shotmk.el.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TagRepository extends JpaRepository<Tag, Integer> {

    @Query("select t from Tag t where t.tag = :tag")
    Tag getTagByTagstring(@Param("tag") String tag);
}
