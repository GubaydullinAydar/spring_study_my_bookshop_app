package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.config.SpringFoxConfig;
import com.example.MyBookShopApp.data.AuthorService;
import com.example.MyBookShopApp.data.Authors;
import com.example.MyBookShopApp.data.SearchWordDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@Api(tags = {SpringFoxConfig.AUTHORS})
public class AuthorsController {

    private final AuthorService authorService;

    @Autowired
    public AuthorsController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @ModelAttribute("searchWordDto")
    public SearchWordDto searchWordDto() {
        return new SearchWordDto();
    }

    @ModelAttribute("authorsMap")
    public Map<String, List<Authors>> authorsMap() {
        return authorService.getAuthorsMap();
    }

    @GetMapping("/authors")
    public String authorPage() {
        return "/authors/index";
    }

    @ApiOperation("method to get map of authors")
    @GetMapping("/api/authors")
    @ResponseBody
    public Map<String, List<Authors>> authors() {
        return authorService.getAuthorsMap();
    }
}
