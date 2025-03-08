package com.example.outbox.service;

import com.example.outbox.model.ConsumedMessage;
import com.example.outbox.repo.MessageLogs;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.UUID;

/**
 * Created by Sherif.Abdulraheem 3/8/2025 - 5:17 PM
 **/

@Slf4j
@RequiredArgsConstructor
public class MessageLog {

    private final MessageLogs logs;

    @Transactional
    public void processed(UUID eventId) {
        logs.save(ConsumedMessage.builder().eventId(eventId).timeOfReceiving(Instant.now()).build());
    }

    @Transactional
    public boolean alreadyProcessed(UUID eventId) {
        return logs.findById(eventId).isPresent();
    }
}
