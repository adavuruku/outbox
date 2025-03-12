package com.example.outbox.event;

import com.example.outbox.model.OutboxEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

/**
 * Created by Sherif.Abdulraheem 08/03/2025 - 17:43
 **/

@Component
public class EventPublisher implements ApplicationEventPublisherAware {
    private ApplicationEventPublisher applicationEventPublisher;
    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    /***
     * This method will publish the event to the method marked as @EventListener
     * @param event the event type
     */
    public void publish(ExportedEvent event) {
        this.applicationEventPublisher.publishEvent(event);
    }
}
