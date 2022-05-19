package com.example.MyBookShopApp.data;

import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "authors")
public class Authors {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String firstName;
    String lastName;

    @OneToMany(mappedBy = "authors")
    @JsonIgnore
    private List<Books> booksList = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Books> getBookList() {
        return booksList;
    }

    public void setBookList(List<Books> booksList) {
        this.booksList = booksList;
    }

    @Override
    public String toString() {
        return firstName + ' ' + lastName;
    }
}
