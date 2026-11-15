package com.aditya.productService.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aditya.productService.dto.ProductDto;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;



@RestController 
@RequestMapping("/products")
public class ProductController {

    @GetMapping("/{id}")
    public String getProduct(@PathVariable String id) {
        return "Product fetched with id: "+id;
        // throw new RuntimeException("Checking");
    }
    

    @PutMapping("/{id}")
    public ProductDto update(@PathVariable String id,@RequestHeader("X-Testing-ID") String uniqueId , @RequestBody ProductDto entity) {
        
        System.out.println("uniqueId came in Product: "+uniqueId);
        System.out.println("Request came in Product: "+entity.getName());
        System.out.println("Request came in Product: "+entity.getPrice());
        
        return entity;
    }
}
