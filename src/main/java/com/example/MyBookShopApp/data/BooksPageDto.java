package com.example.MyBookShopApp.data;

import java.util.List;

public class BooksPageDto {

    private Integer count;
    private List<Books> books;

    public BooksPageDto(List<Books> books) {
        this.count = books.size();
        ;
        this.books = books;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<Books> getBooks() {
        return books;
    }

    public void setBooks(List<Books> books) {
        this.books = books;
    }
}
