package com.shotmk.el.services;

import com.shotmk.el.entity.Comment;

import java.util.List;

public interface CommentService {

    public Comment getComment(int id);

    public Comment addComment(Comment comment);

    public void deleteComment(Comment comment);

    public List<Comment> getChildComments(int parentId);

}
