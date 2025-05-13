package com.dbp.recu_hack1.repository;

import com.dbp.recu_hack1.domain.Order;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
};
