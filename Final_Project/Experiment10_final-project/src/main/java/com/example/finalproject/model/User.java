package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long id;
    private String username;
    private String email;
    private String password;
    private String role;
    private String fullName;
    private String phone;
    private String address;
    private String city;
    private String zipCode;
    private String country;
}
