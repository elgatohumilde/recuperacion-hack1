package com.dbp.recu_hack1.listener;

import com.dbp.recu_hack1.event.OrderCreatedEvent;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class EmailNotificationListener {

    private static final Logger logger = LogManager.getLogger(EmailNotificationListener.class);

    @EventListener
    @Async
    public void handleOrderCreatedEvent(OrderCreatedEvent event) {
        String email = event.getOrder().getEmail();
        logger.info("Email sent to {} confirming order {}", email, event.getOrder().getId());
    }
};
