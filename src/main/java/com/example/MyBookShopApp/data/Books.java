package com.example.MyBookShopApp.data;


import com.example.MyBookShopApp.config.SpringFoxConfig;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "books")
@Api(tags = {SpringFoxConfig.BOOK_ENTITY})
@JsonIgnoreProperties({"authors"})
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private Authors authors;

    @Column(name = "pub_date")
    @ApiModelProperty("date of book publication")
    private Date pubDate;

    @Column(name = "is_bestseller")
    @ApiModelProperty("if is bestseller = 1, else 0")
    private Integer isBestseller;


    private String slug;

    private String title;

    private String image;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "price")
    @JsonProperty("price")
    private Integer priceOld;

    @Column(name = "discount")
    @JsonProperty("discount")
    private Double price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPriceOld() {
        return priceOld;
    }

    public void setPriceOld(Integer priceOld) {
        this.priceOld = priceOld;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Authors getAuthors() {
        return authors;
    }

    public void setAuthors(Authors authors) {
        this.authors = authors;
    }

    public Date getPubDate() {
        return pubDate;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }

    public Integer getIsBestseller() {
        return isBestseller;
    }

    public void setIsBestseller(Integer isBestseller) {
        this.isBestseller = isBestseller;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", author=" + authors +
                ", title='" + title + '\'' +
                ", priceOld='" + priceOld + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
