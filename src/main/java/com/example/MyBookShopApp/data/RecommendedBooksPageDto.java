package com.example.MyBookShopApp.data;

import java.util.List;

public class RecommendedBooksPageDto {

    private Integer count;
    private List<Books> books;

    public RecommendedBooksPageDto(Integer count, List<Books> books) {
        this.count = count;
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
