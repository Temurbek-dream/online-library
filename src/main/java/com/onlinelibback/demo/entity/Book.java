package com.onlinelibback.demo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.SEQUENCE;



@Entity(name = "book")
@Table(name = "book")
public class Book {
    @Id
    @SequenceGenerator(
            name = "book_sequence",
            sequenceName = "book_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "book_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(name = "AuthorName", nullable = false)
    private String nameOfAuthor;

    @Column(name = "DateOfPublished", nullable = false)
    private LocalDateTime publishedTime;

    @Column(name = "Price", nullable = false)
    private Double price;

    @Column(name = "Pages", nullable = false)
    private Integer numOfPages;

    @Column(name = "Title", nullable = false)
    private String titleOfbook;


    @ManyToOne
    @JoinColumn(
            name = "category_id",
            nullable = false,
            referencedColumnName ="id",
            foreignKey =@ForeignKey(
                    name ="category_book_fk"
            )
    )
    public Category category;

    public Book() {
    }

    public Book(String nameOfAuthor,
                LocalDateTime publishedTime,
                Double price,
                Integer numOfPages,
                String titleOfbook)
    {
        this.nameOfAuthor = nameOfAuthor;
        this.publishedTime = publishedTime;
        this.price = price;
        this.numOfPages = numOfPages;
        this.titleOfbook = titleOfbook;
    }

    public Long getBookId() {
        return id;
    }

    public void setBookId(Long bookId) {
        this.id = id;
    }

    public String getNameOfAuthor() {
        return nameOfAuthor;
    }

    public void setNameOfAuthor(String nameOfAuthor) {
        this.nameOfAuthor = nameOfAuthor;
    }

    public LocalDateTime getPublishedTime() {
        return publishedTime;
    }

    public void setPublishedTime(LocalDateTime publishedTime) {
        this.publishedTime = publishedTime;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getNumOfPages() {
        return numOfPages;
    }

    public void setNumOfPages(Integer numOfPages) {
        this.numOfPages = numOfPages;
    }

    public String getTitleOfbook() {
        return titleOfbook;
    }

    public void setTitleOfbook(String titleOfbook) {
        this.titleOfbook = titleOfbook;
    }

//    public Category getBookCategories() {
//        return category;
//    }
//
//    public void setBookCategories(Category category) {
//        this.category = category;
//    }


    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", nameOfAuthor='" + nameOfAuthor + '\'' +
                ", publishedTime=" + publishedTime +
                ", price=" + price +
                ", numOfPages=" + numOfPages +
                ", titleOfbook='" + titleOfbook + '\'' +
                '}';
    }
}