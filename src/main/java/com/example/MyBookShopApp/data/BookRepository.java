package com.example.MyBookShopApp.data;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Books, Integer> {

    List<Books> findBooksByAuthors_FirstName(String name);

    @Query("FROM Books")
    List<Books> customFindAllBooks();

    List<Books> findBooksByAuthorsFirstNameContaining(String authorFirstName);

    List<Books> findBooksByTitleContaining(String bookTitle);

    List<Books> findBooksByPriceOldBetween(Integer min, Integer max);

    List<Books> findBooksByPriceOldIs(Integer price);

    @Query("from Books where isBestseller = 1")
    List<Books> getBestsellers();

    @Query(value = "SELECT * FROM BOOKS WHERE discount = (SELECT MAX(discount) FROM BOOKS)", nativeQuery = true)
    List<Books> getBooksWithMaxDiscount();

    Page<Books> findBooksByTitleContaining(String bookTitle, Pageable nextPage);

    Page<Books> findBooksByPubDateBetween(Date from, Date to, Pageable nextPage);
}
