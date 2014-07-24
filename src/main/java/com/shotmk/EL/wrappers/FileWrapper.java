package com.shotmk.EL.wrappers;

public class FileWrapper {

    private String fileName;
    private String extension;
    private byte[] file;


    public FileWrapper() {
        this.fileName = null;
        this.extension = null;
        this.file = null;
    }

    public FileWrapper(String fileName, String extension, byte[] file) {
        this.fileName = fileName;
        this.extension = extension;
        this.file = file;
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

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }
}
