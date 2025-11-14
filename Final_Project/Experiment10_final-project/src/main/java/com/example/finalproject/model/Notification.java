package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notification {
    private Long id;
    private String message;
    private String type; // "order", "info", "warning", etc.
    private LocalDateTime timestamp;
    private boolean read;
    private Long userId; // null for global notifications
}
