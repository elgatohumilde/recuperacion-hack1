package com.dbp.recu_hack1.listener;

import com.dbp.recu_hack1.event.OrderCreatedEvent;
import com.dbp.recu_hack1.repository.OrderRepository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class InventoryUpdateListener {

    private static final Logger logger = LogManager.getLogger(InventoryUpdateListener.class);
    private final OrderRepository orderRepository;

    @EventListener
    @Async
    public void handleOrderCreatedEvent(OrderCreatedEvent event) {
        logger.info("New available stock: {}", 10000 - orderRepository.findAll().size());
    }
};
