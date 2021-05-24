package com.onlinelibback.demo.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "CustomerBook")
@Table(name = "customerBook")
public class CustomerBook {
    @EmbeddedId
    private CustomerBookId id;

    @ManyToOne
    @MapsId("customerId")
    @JoinColumn(name = "customer_id",
            foreignKey =@ForeignKey(name = "customer_book_id_fk")
    )
    private Customer customer;

    @ManyToOne
    @MapsId("bookId")
    @JoinColumn(
            name = "book_id",
            foreignKey = @ForeignKey(
                    name = "book_customer_id_fk"
            )
    )
    private Book book;

    @Column(
            name = "created_at",
            nullable = false,
            columnDefinition = "TIMESTAMP WITHOUT TIME ZONE"
    )
    private LocalDateTime createdAt;

    public CustomerBook(CustomerBookId id,
                        Customer customer,
                        Book book,
                        LocalDateTime createdAt)
    {
        this.id = id;
        this.customer = customer;
        this.book = book;
        this.createdAt = createdAt;
    }

    public CustomerBook() {

    }

    public CustomerBookId getId() {
        return id;
    }

    public void setId(CustomerBookId id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}