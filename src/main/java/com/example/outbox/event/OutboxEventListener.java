package com.example.outbox.event;

import com.example.outbox.model.OutboxEvent;
import com.example.outbox.repo.MessageLogs;
import com.example.outbox.repo.OutboxEvents;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;

/**
 * Created by Sherif.Abdulraheem 3/8/2025 - 4:55 PM
 **/
@RequiredArgsConstructor
public class OutboxEventListener {
    private final OutboxEvents events;
    private final MessageLogs logs;

    @EventListener
    public void handleOutboxEvent(ExportedEvent event) {

        OutboxEvent outboxEvent = events.save(of(event));

        /***
         * Delete the event once written, so that the outbox doesn't grow.
         * the CDC eventing polls the database log entry and not the table in the database
         */
        events.delete(outboxEvent);
    }

    private static OutboxEvent of(ExportedEvent exportedEvent) {
        return OutboxEvent.builder()
                .aggregateId(exportedEvent.getAggregateId())
                .aggregateType(exportedEvent.getAggregateType())
                .type(exportedEvent.getType())
                .timestamp(exportedEvent.getTimestamp())
                .payload(exportedEvent.getPayload()).build();

    }
}
