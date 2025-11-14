package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Product;
import com.example.demo.service.EcommerceService;

@Controller
public class ProductController {

    @Autowired
    private EcommerceService service;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("cartSize", service.getCart().getTotalItems());
        return "home";
    }

    @GetMapping("/home")
    public String homePage(Model model) {
        model.addAttribute("cartSize", service.getCart().getTotalItems());
        return "home";
    }

    @GetMapping("/products")
    public String getProducts(@RequestParam(required = false) String search,
                             @RequestParam(required = false) String category,
                             @RequestParam(required = false) Double minPrice,
                             @RequestParam(required = false) Double maxPrice,
                             Model model) {
        List<Product> products;
        if (search != null || category != null || minPrice != null || maxPrice != null) {
            products = service.searchAndFilterProducts(search, category, minPrice, maxPrice);
        } else {
            products = service.getAllProducts();
        }
        model.addAttribute("products", products);
        model.addAttribute("cartSize", service.getCart().getTotalItems());
        model.addAttribute("searchQuery", search);
        model.addAttribute("selectedCategory", category);
        model.addAttribute("minPrice", minPrice);
        model.addAttribute("maxPrice", maxPrice);
        return "products_new";
    }

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("cartSize", service.getCart().getTotalItems());
        return "about";
    }

    @GetMapping("/contact")
    public String contact(Model model) {
        model.addAttribute("cartSize", service.getCart().getTotalItems());
        return "contact";
    }
}
