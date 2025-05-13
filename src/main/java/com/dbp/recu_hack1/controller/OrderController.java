package com.dbp.recu_hack1.controller;

import com.dbp.recu_hack1.domain.Order;
import com.dbp.recu_hack1.event.OrderCreatedEvent;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    private ApplicationEventPublisher eventPublisher;

    @PostMapping
    public String createOrder(@RequestBody Order order) {
        eventPublisher.publishEvent(new OrderCreatedEvent(this, order));
        return "New order: " + order.getId();
    }

}
