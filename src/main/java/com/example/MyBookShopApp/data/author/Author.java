package com.example.MyBookShopApp.data.author;

public class Author {

    Integer id;

    String author;

    String shortBiography;

    String fullBiography;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getShortBiography() {
        return shortBiography;
    }

    public void setShortBiography(String shortBiography) {
        this.shortBiography = shortBiography;
    }

    public String getFullBiography() {
        return fullBiography;
    }

    public void setFullBiography(String fullBiography) {
        this.fullBiography = fullBiography;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", shortBiography='" + shortBiography + '\'' +
                ", fullBiography='" + fullBiography + '\'' +
                '}';
    }
}
