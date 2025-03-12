package com.example.outbox.repo;

import com.example.outbox.model.OutboxEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Created by Sherif.Abdulraheem 3/8/2025 - 4:55 PM
 **/
@Repository
public interface OutboxEvents extends JpaRepository<OutboxEvent, UUID>  {
}
