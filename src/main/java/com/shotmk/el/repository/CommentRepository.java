package com.shotmk.el.repository;

import com.shotmk.el.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

    @Query("select c from Comment c where c.parent.id = :parentId order by creationDate asc")
    List<Comment> getChildComments(@Param("parentId") int parentId);

}
