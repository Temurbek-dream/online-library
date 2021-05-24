package com.onlinelibback.demo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long categoryId;

    @Column(name ="amount")
    private Double amountOfmoney;

    @Column(name = "paidDate")
    private LocalDateTime paidDate;

}
