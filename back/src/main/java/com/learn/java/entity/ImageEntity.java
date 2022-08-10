package com.learn.java.entity;


//@Table(name = "images")
public class ImageEntity {
    Long id;
    String fileName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String file) {
        this.fileName = file;
    }
}
