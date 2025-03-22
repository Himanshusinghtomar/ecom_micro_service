package com.ecommerce.userservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.HashMap;
import java.util.Scanner;


@RestController
@RequestMapping("/users")
public class UserController {
int a = 24;
    @GetMapping
    public String getUsers() {
        return "List of users";
    }

    Scanner scanner = new Scanner(System.in);

    HashMap<String,Integer> hs = new HashMap<>();

    void love(){

    }


}

