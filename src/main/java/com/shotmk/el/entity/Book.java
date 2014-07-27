package com.shotmk.el.entity;


import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "book")
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Size(max = 40)
    private String name;

    private String publisher;

    private String author;

    @Size(max = 500)
    private String description;

    @Size(max = 4)
    private String format;

    private String filename;

    @Lob
    @Column(length = 20971520)
    private byte[] book;


    @Column(length = 100000)
    @Type(type = "image")
    private byte[] image;

    private double size;

    @Column(nullable = false)
    private int rate;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "book")
    private List<Comment> comments;

    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Tag> tags;

    public Book() {
    }

    public Book(String name, String publisher, String author, String description, String format, String filename, byte[] book, byte[] image, double size, List<Tag> tags) {
        this.name = name;
        this.publisher = publisher;
        this.author = author;
        this.description = description;
        this.format = format;
        this.filename = filename;
        this.book = book;
        this.image = image;
        this.size = size;
        this.tags = tags;
        this.rate = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public byte[] getBook() {
        return book;
    }

    public void setBook(byte[] book) {
        this.book = book;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public List<Comment> getComments() {
        Collections.sort(comments);
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public void incrementRate() {
        this.rate++;
    }

    public void decrementRate() {
        this.rate--;
    }

}
