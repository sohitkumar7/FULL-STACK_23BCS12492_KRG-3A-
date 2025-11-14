package com.example.demo.model;

import java.time.LocalDateTime;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private Long id;
    private Map<Product, Integer> itemQuantities;
    private double total;
    private String customerName; // Simple for demo
    private LocalDateTime date;
}
