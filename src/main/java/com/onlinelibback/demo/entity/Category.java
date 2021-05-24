package com.onlinelibback.demo.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "Category")
@Table(name = "category")
public class Category {
    @Id
    @SequenceGenerator(
            name = "category_sequence",
            sequenceName = "category_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "category_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(name = "categoryName", nullable = false)
    private String categoryName;

    @OneToMany(
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            mappedBy = "category"
    )
    private List<Book> books = new ArrayList<>();

    public Category(String categoryName) {
        this.categoryName = categoryName;
    }

    public Category() {
    }

    public Long getCategoryId() {
        return id;
    }

    public void setCategoryId(Long categoryId) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + id +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}