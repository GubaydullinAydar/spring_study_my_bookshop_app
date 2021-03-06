package com.example.MyBookShopApp.config;

import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;

@Configuration
public class SpringFoxConfig {

    public static final String BOOK_REST = "BookRest";
    public static final String AUTHORS = "Authors";
    public static final String BOOK_ENTITY = "BookEntity";

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .paths(PathSelectors.any())
                .build()
                .tags(new Tag(BOOK_REST, "book data api"))
                .tags(new Tag(AUTHORS, "authors data"))
                .tags(new Tag(BOOK_ENTITY, "entity representing a book"))
                .apiInfo(apiInfo());
    }

    public ApiInfo apiInfo() {
        return new ApiInfo(
                "Bookshop API",
                "API for bookstore",
                "1.0",
                "https://www.test.org",
                new Contact("API owner", "https://www.owner.org", "owner@rmailer.org"),
                "API license",
                "https://www.license.edu.org",
                new ArrayList<>()
        );
    }

}
