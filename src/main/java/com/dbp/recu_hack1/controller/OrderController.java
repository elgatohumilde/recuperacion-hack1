package com.dbp.recu_hack1.controller;

import com.dbp.recu_hack1.domain.Order;
import com.dbp.recu_hack1.dto.OrderDTO;
import com.dbp.recu_hack1.event.OrderCreatedEvent;
import com.dbp.recu_hack1.repository.OrderRepository;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final ApplicationEventPublisher eventPublisher;
    private final OrderRepository orderRepository;

    @PostMapping
    public String createOrder(@RequestBody OrderDTO order) {
        Order createdOrder = new Order();
        createdOrder.setDescription(order.getDescription());
        createdOrder.setEmail(order.getEmail());
        orderRepository.save(createdOrder);
        Order newOrder = orderRepository.findAll().get(0);

        eventPublisher.publishEvent(new OrderCreatedEvent(this, newOrder));
        return "New order: " + newOrder.getId();
    }

}
