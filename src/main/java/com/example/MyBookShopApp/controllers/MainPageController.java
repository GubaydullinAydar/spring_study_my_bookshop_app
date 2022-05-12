package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.data.BookService;
import com.example.MyBookShopApp.data.author.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bookshop")
public class MainPageController {

    private final BookService bookService;
    private final AuthorService authorService;

    @Autowired
    public MainPageController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @GetMapping("/main")
    public String mainPage(Model model) {
        model.addAttribute("bookData", bookService.getBooksData());
        return "index";
    }

    @GetMapping("/genres")
    public String genresPage() {
        return "genres/index";
    }

    @GetMapping("/genres/slug")
    public String genresSlugPage() {
        return "genres/slug";
    }

    @GetMapping("/authors")
    public String authorsPage(Model model) {
        model.addAttribute("authorData", authorService.getAuthorData());
        return "authors/index";
    }

    @GetMapping("/authors/slug")
    public String authorsSlugPage() {
        return "authors/slug";
    }

    @GetMapping("/authors/slug/{authorId}")
    public String authorSlugPage(@PathVariable Integer authorId, Model model) {
        model.addAttribute("authorData", authorService.getAuthorData(authorId));
        model.addAttribute("bookData", bookService.getBooksData(authorId));
        return "authors/slugAuthor";
    }
}
