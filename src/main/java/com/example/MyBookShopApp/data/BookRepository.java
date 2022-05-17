package com.example.MyBookShopApp.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Books, Integer> {

    List<Books> findBooksByAuthors_FirstName(String name);

    @Query("FROM Books")
    List<Books> customFindAllBooks();
}
