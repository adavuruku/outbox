package com.example.outbox.repo;


import com.example.outbox.model.ConsumedMessage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * Created by Sherif.Abdulraheem 3/8/2025 - 5:11 PM
 **/
public interface MessageLogs extends JpaRepository<ConsumedMessage, UUID> {
}
