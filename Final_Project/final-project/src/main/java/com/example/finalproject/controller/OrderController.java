package com.example.demo.controller;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Cart;
import com.example.demo.model.Order;
import com.example.demo.model.Product;
import com.example.demo.service.EcommerceService;

@Controller
public class OrderController {

    @Autowired
    private EcommerceService ecommerceService;

    @GetMapping("/order")
    public String showOrderForm(Model model) {
        Cart cart = ecommerceService.getCart();
        model.addAttribute("cart", cart);
        model.addAttribute("cartSize", cart.getTotalItems());
        return "order";
    }

    @PostMapping("/order")
    public String placeOrder(@RequestParam String customerName,
                           @RequestParam String email,
                           @RequestParam String phone,
                           @RequestParam String address,
                           @RequestParam String city,
                           @RequestParam String zipCode,
                           @RequestParam String country,
                           @RequestParam String cardNumber,
                           @RequestParam String expiryDate,
                           @RequestParam String cvv,
                           Model model) {
        Cart cart = ecommerceService.getCart();
        if (cart.getItemQuantities().isEmpty()) {
            return "redirect:/cart";
        }

        // Create order using service
        Order order = ecommerceService.placeOrder(customerName);

        model.addAttribute("order", order);
        return "order-confirmation";
    }
}
