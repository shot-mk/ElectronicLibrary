package com.shotmk.el.entity;


import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "comment")
public class Comment implements Comparable<Comment> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "parentId")
    private Comment parent;

    @ManyToOne
    @JoinColumn(name = "bookId")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    private String comment;

    private Date creationDate;


    public Comment() {
    }

    public Comment(Comment parent, Book book, User user, String comment) {
        this.parent = parent;
        this.book = book;
        this.user = user;
        this.comment = comment;
        this.creationDate = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Comment getParent() {
        return parent;
    }

    public void setParent(Comment parent) {
        this.parent = parent;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getPrettyDate() {
        DateFormat df = new SimpleDateFormat("yyyy.MM.dd 'at' HH:mm:ss");
        return df.format(this.creationDate);
    }

    @Override
    public int compareTo(Comment o) {
        return getCreationDate().compareTo(o.getCreationDate());
    }
}
