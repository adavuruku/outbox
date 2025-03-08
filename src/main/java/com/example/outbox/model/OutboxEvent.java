package com.example.outbox.model;

import com.fasterxml.jackson.databind.JsonNode;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Value;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

import java.time.Instant;
import java.util.UUID;

/**
 * Created by Sherif.Abdulraheem 3/8/2025 - 4:57 PM
 */
@Entity
@Table(name = "outbox_events", schema = "public")
@Value
@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class OutboxEvent { // Configure and ensure binlog retention is not too short

    /**
     * Unique id of each message;
     * can be used by Kafka consumers to detect any duplicate events, e.g. when restarting to read messages after a failure.
     * Generated when creating a new event.
     */
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    UUID id;

    @Column(name = "aggregate_type", nullable = false)
    String aggregateType;

    @Column(name = "aggregate_id", nullable = false)
    Long aggregateId;

    @Column(name = "type")
    String type;

    @Column(name = "payload")
    JsonNode payload;

    @Column(name = "timestamp", nullable = false, updatable = false)
    Instant timestamp;

    @Version
    @Column(name = "version")
    Integer version;
}
