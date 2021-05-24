package com.onlinelibback.demo.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CustomerBookId implements Serializable {

    @Column(name = "book_id")
    private Long book_id;

    @Column(name = "customer_id")
    private Long customer_id;

    public CustomerBookId(Long book_id,
                          Long customer_id) {
        this.book_id = book_id;
        this.customer_id = customer_id;
    }

    public CustomerBookId() {
    }

    public Long getBook_id() {
        return book_id;
    }

    public void setBook_id(Long book_id) {
        this.book_id = book_id;
    }

    public Long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Long customer_id) {
        this.customer_id = customer_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerBookId customerBookId = (CustomerBookId) o;
        return Objects.equals(book_id, customerBookId.book_id)&&Objects
                .equals(customer_id, customerBookId.customer_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(book_id,customer_id);
    }


}