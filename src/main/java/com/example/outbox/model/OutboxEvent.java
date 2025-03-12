package com.example.outbox.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Immutable;
import org.springframework.data.annotation.Version;

import java.time.Instant;
import java.util.UUID;

/**
 * Created by Sherif.Abdulraheem 3/8/2025 - 4:57 PM
 */
@Entity
@Table(name = "outbox_events")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OutboxEvent { // Configure and ensure binlog retention is not too short

    /**
     * Unique id of each message;
     * can be used by Kafka consumers to detect any duplicate events, e.g. when restarting to read messages after a failure.
     * Generated when creating a new event.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", columnDefinition = "BINARY(16)", updatable = false, nullable = false)
    UUID id;

    @Column(name = "aggregate_type", nullable = false)
    String aggregateType;

    @Column(name = "aggregate_id", nullable = false)
    Long aggregateId;

    @Column(name = "type")
    String type;

    @Column(name = "payload")
    String payload;

    @Column(name = "timestamp", nullable = false, updatable = false)
    Instant timestamp;

    @Version
    @Column(name = "version")
    Integer version;
}
