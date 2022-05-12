package com.example.MyBookShopApp.data.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AuthorService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Author> getAuthorData() {
        List<Author> authors = jdbcTemplate.query("SELECT * FROM author",
                (ResultSet rs, int rowNum) -> {
                    Author author = new Author();
                    author.setId(rs.getInt("id"));
                    author.setAuthor(rs.getString("author"));
                    author.setShortBiography(rs.getString("shortBiography"));
                    author.setFullBiography(rs.getString("fullBiography"));
                    return author;
                });
        return new ArrayList<>(authors);
    }

    public Author getAuthorData(Integer authorId) {
        return jdbcTemplate.queryForObject("SELECT * FROM author t WHERE t.id = ?",
                (ResultSet rs, int rowNum) -> {
                    Author author = new Author();
                    author.setId(rs.getInt("id"));
                    author.setAuthor(rs.getString("author"));
                    author.setShortBiography(rs.getString("shortBiography"));
                    author.setFullBiography(rs.getString("fullBiography"));
                    return author;
                }, authorId);
    }
}
