package com.onlinelibback.demo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;


@NoArgsConstructor
@Entity(name = "customer")
public class Customer
{
    @Id
    @SequenceGenerator(
            name = "customer_sequence",
            sequenceName = "customer_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "customer_sequence"
    )
    @Column(
            name = "id"
    )
    private Long id;

    @Column(name = "Fullname",nullable = false)
    private String fullName;

    @Column(name = "Address",nullable = false)
    private String address;

    @Column(name = "PhoneNumber",nullable = false)
    private String phoneNumber;

    @Column(name = "Email",nullable = false)
    private String email;

    @Column(name = "isActive",nullable = false)
    private Boolean isActive;

    @OneToMany(
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            mappedBy = "customer"
    )
    private List<CustomerBook> customerBooks = new ArrayList<>();


    public Customer(String fullName,
                    String address,
                    String phoneNumber,
                    String email,
                    Boolean isActive
//                    List<Category> category
    )
    {
        this.fullName = fullName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.isActive = isActive;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
