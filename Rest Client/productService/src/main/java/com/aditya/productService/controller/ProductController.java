package com.aditya.productService.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aditya.productService.dto.ProductDto;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController 
@RequestMapping("/products")
public class ProductController {
    @GetMapping("/{id}")
    public String getProduct(@PathVariable String id) {
        return "Product fetched with id: "+id;
    }
    
    @PostMapping
    public ResponseEntity<ProductDto> checkPost(@RequestBody ProductDto requestDto) {
        System.out.println("Request in productService -> "+requestDto);       
        return ResponseEntity.ok(requestDto);                            
    }
}
