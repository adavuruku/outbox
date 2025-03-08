package com.example.outbox.event;

import com.example.outbox.model.OutboxEvent;
import com.example.outbox.repo.OutboxEvents;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;

import java.util.UUID;

/**
 * Created by Sherif.Abdulraheem 3/8/2025 - 4:55 PM
 **/
@RequiredArgsConstructor
public class OutboxEventListener {
    private final OutboxEvents events;

    @EventListener
    public void handleOutboxEvent(ExportedEvent event) {
        events.save(of(event));
    }

    private static OutboxEvent of(ExportedEvent exportedEvent) {
        return OutboxEvent.builder()
                .id(UUID.randomUUID())
                .aggregateId(exportedEvent.getAggregateId())
                .aggregateType(exportedEvent.getAggregateType())
                .type(exportedEvent.getType())
                .timestamp(exportedEvent.getTimestamp())
                .payload(exportedEvent.getPayload()).build();

    }
}
