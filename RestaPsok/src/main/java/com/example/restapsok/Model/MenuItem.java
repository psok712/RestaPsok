package com.example.restapsok.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name="menu")
public class MenuItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="dish")
    private String dish;

    @Column(name="price")
    private BigDecimal price;

    @Column(name="cooking_time")
    private int cookingTimeMinute;

    @Column(name="amount")
    private int amount;
}
