package com.example.demo.model;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

import lombok.Data;

@Data
public class Cart {
    private Map<Product, Integer> items = new HashMap<>();

    public void addProduct(Product product) {
        items.put(product, items.getOrDefault(product, 0) + 1);
    }

    public void removeProduct(Product product) {
        if (items.containsKey(product)) {
            int quantity = items.get(product);
            if (quantity > 1) {
                items.put(product, quantity - 1);
            } else {
                items.remove(product);
            }
        }
    }

    public void removeAll(Product product) {
        items.remove(product);
    }

    public void updateQuantity(Product product, int quantity) {
        if (quantity <= 0) {
            items.remove(product);
        } else {
            items.put(product, quantity);
        }
    }

    public int getQuantity(Product product) {
        return items.getOrDefault(product, 0);
    }

    public List<Product> getItems() {
        List<Product> productList = new ArrayList<>();
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                productList.add(entry.getKey());
            }
        }
        return productList;
    }

    public Map<Product, Integer> getItemQuantities() {
        return new HashMap<>(items);
    }

    public double getTotal() {
        return items.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();
    }

    public int getTotalItems() {
        return items.values().stream().mapToInt(Integer::intValue).sum();
    }

    public void clear() {
        items.clear();
    }
}
