package com.dbp.recu_hack1.listener;

import com.dbp.recu_hack1.event.OrderCreatedEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class AuditLogListener {

    private static final Logger logger = LogManager.getLogger(AuditLogListener.class);

    @EventListener
    @Async
    public void handleOrderCreatedEvent(OrderCreatedEvent event) {
        logger.info("Audit log: Order {} placed by {}",
                event.getOrder().getId(), event.getOrder().getEmail());
    }
};
