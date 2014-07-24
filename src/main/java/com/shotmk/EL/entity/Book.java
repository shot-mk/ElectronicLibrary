package com.shotmk.EL.entity;


import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "book")
public class Book implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Size(max = 40)
    String name;

    String publisher;

    String author;

    @Size(max = 500)
    String description;

    @Size(max = 3)
    String format;

    String filename;

    @Lob
    @Column(length = 20000000)
    byte[] book;

    @Lob
    @Column(length = 100000)
    byte[] image;

    double size;

    public Book() {
    }

    public Book(String name, String publisher, String author, String description, String format, String filename, byte[] book, byte[] image, double size) {
        this.name = name;
        this.publisher = publisher;
        this.author = author;
        this.description = description;
        this.format = format;
        this.filename = filename;
        this.book = book;
        this.image = image;
        this.size = size;
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
}
