package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Cart;
import com.example.demo.service.EcommerceService;

@Controller
public class CartController {

    @Autowired
    private EcommerceService service;

    @GetMapping("/cart")
    public String viewCart(Model model) {
        Cart cart = service.getCart();
        model.addAttribute("cart", cart);
        model.addAttribute("total", cart.getTotal());
        model.addAttribute("cartSize", cart.getTotalItems());
        model.addAttribute("itemQuantities", cart.getItemQuantities());
        return "cart";
    }

    @PostMapping("/cart/add")
    public String addToCart(@RequestParam Long productId) {
        service.addToCart(productId);
        return "redirect:/cart";
    }

    @PostMapping("/cart/remove")
    public String removeFromCart(@RequestParam Long productId) {
        service.removeFromCart(productId);
        return "redirect:/cart";
    }

    @PostMapping("/cart/update")
    public String updateQuantity(@RequestParam Long productId, @RequestParam int quantity) {
        service.updateCartQuantity(productId, quantity);
        return "redirect:/cart";
    }

    @PostMapping("/cart/removeAll")
    public String removeAllFromCart(@RequestParam Long productId) {
        service.removeAllFromCart(productId);
        return "redirect:/cart";
    }
}
