package com.shotmk.EL.wrappers;

public class BookFileWrapper {

    private String fileName;
    private String extension;
    private byte[] book;


    public BookFileWrapper() {
        this.fileName = null;
        this.extension = null;
        this.book = null;
    }

    public BookFileWrapper(String fileName, String extension, byte[] book) {
        this.fileName = fileName;
        this.extension = extension;
        this.book = book;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public byte[] getBook() {
        return book;
    }

    public void setBook(byte[] book) {
        this.book = book;
    }
}
