package com.example.outbox.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

import java.time.Instant;
import java.util.UUID;

/**
 * Created by Sherif.Abdulraheem 3/8/2025 - 4:56 PM
 */
@Entity
@Table(name = "consumed_messages", schema = "public")
@Value
@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class ConsumedMessage {

    @Id
    @Column(name="event_id")
    UUID eventId;

    @Column(name = "time_of_receiving", nullable = false, updatable = false)
    Instant timeOfReceiving;

    @Version
    @Column(name = "version")
    int version;
}
