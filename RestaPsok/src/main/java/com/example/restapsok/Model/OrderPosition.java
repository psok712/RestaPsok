package com.example.restapsok.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="order_position")
public class OrderPosition {
    @Id
    @GeneratedValue
    public Long id;
    @Column(name="id_guest", nullable = false)
    public Long idGuest;
    @Column(name="id_menu_item", nullable = false)
    public Long idMenuItem;
    @Column(name="status_order", nullable = false)
    public StatusOrder statusOrder = StatusOrder.PENDING;
}
