package com.dbp.recu_hack1.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "customer_order")
@Data

public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false, unique = true)
    private String email;

};
