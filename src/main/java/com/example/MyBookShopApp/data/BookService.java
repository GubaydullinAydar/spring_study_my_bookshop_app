package com.example.MyBookShopApp.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> getBooksData() {
        List<Book> books = jdbcTemplate.query(
                "SELECT t.id, a.author, t.title, t.priceOld, t.price  FROM books t INNER JOIN author a WHERE a.id = t.authorId",
                (ResultSet rs, int rowNum) -> {
                    Book book = new Book();
                    book.setId(rs.getInt("id"));
                    book.setAuthor(rs.getString("author"));
                    book.setTitle(rs.getString("title"));
                    book.setPriceOld(rs.getString("priceOld"));
                    book.setPrice(rs.getString("price"));
                    return book;
                });
        return new ArrayList<>(books);
    }

    public List<Book> getBooksData(Integer authorId) {
        List<Book> books = jdbcTemplate.query(
                "SELECT t.id, a.author, t.title, t.priceOld, t.price  FROM books t INNER JOIN author a WHERE a.id = t.authorId and t.authorId = ? ",
                (ResultSet rs, int rowNum) -> {
                    Book book = new Book();
                    book.setId(rs.getInt("id"));
                    book.setAuthor(rs.getString("author"));
                    book.setTitle(rs.getString("title"));
                    book.setPriceOld(rs.getString("priceOld"));
                    book.setPrice(rs.getString("price"));
                    return book;
                }, authorId);
        return new ArrayList<>(books);
    }
}
