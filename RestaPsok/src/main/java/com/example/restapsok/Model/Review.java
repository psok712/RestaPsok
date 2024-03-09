package com.example.restapsok.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="review")
@Data
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="order_id")
    private Long orderId;

    @Column(name="grade")
    private int grade;

    @Column(name="review")
    private String review;
}
