package com.example.MyBookShopApp.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Books> getBooksData() {
        return bookRepository.findAll();
    }

    public List<Books> getBooksByAuthor(String authorName) {
        return bookRepository.findBooksByAuthorsFirstNameContaining(authorName);
    }

    ;

    public List<Books> getBooksByTitle(String title) {
        return bookRepository.findBooksByTitleContaining(title);
    }

    public List<Books> getBooksWithPriceBetween(Integer min, Integer max) {
        return bookRepository.findBooksByPriceOldBetween(min, max);
    }

    public List<Books> getBooksWithPrice(Integer price) {
        return bookRepository.findBooksByPriceOldIs(price);
    }

    public List<Books> getBooksWithMaxPrice() {
        return bookRepository.getBooksWithMaxDiscount();
    }

    public List<Books> getBestsellers() {
        return bookRepository.getBestsellers();
    }
}
