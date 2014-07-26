package com.shotmk.el.services.impl;

import com.shotmk.el.entity.Comment;
import com.shotmk.el.repository.CommentRepository;
import com.shotmk.el.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Comment getComment(int id) {
        Comment comment = commentRepository.findOne(id);
        return comment;
    }

    @Override
    public Comment addComment(Comment comment) {
        Comment newComment = commentRepository.saveAndFlush(comment);
        return newComment;
    }

    @Override
    public void deleteComment(Comment comment) {
        commentRepository.delete(comment);
    }

    @Override
    public List<Comment> getChildComments(int parentId) {
        return commentRepository.getChildComments(parentId);
    }

}
