package com.aditya.productService.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController 
@RequestMapping("/products")
public class ProductController {
    
    @GetMapping("/{id}")
    public String getProduct(@PathVariable String id) {
        return "Product with id: "+id;
    }

    @GetMapping("/shoes/{id}")
    public ResponseEntity<String> getShoe(@PathVariable String id) {
        return ResponseEntity.ok("Product with id: "+id);
    }

    @PostMapping
    public String addProduct(@RequestBody String entity) {
        return "live-> "+entity;
    }
    
    
}
