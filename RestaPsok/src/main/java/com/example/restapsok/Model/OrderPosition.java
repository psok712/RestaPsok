package com.example.restapsok.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="order_position")
public class OrderPosition {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="id_guest", updatable = false, nullable = false)
    private Long idGuest;

    @Column(name="id_menu_item", updatable = false, nullable = false)
    private Long idMenuItem;

    @Column(name="status_order", nullable = false)
    private StatusOrder statusOrder = StatusOrder.PENDING;
}
