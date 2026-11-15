package com.aditya.orderService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aditya.orderService.client.ProductClient;
import com.aditya.orderService.client.ProductClient2;
import com.aditya.orderService.dto.ProductDto;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController 
@RequestMapping("/orders")
public class OrderController {

    @Autowired 
    ProductClient productClient;

    @Autowired 
    ProductClient2 productClient2;

    @GetMapping("/{id}")
    public ResponseEntity<String> getOrder(@PathVariable String id) {
        String response = productClient.getProductById(id);
        
        System.out.println("Response from product api call is: "+response);

        return ResponseEntity.ok("Order call successful: "+response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDto> updateOrder(@PathVariable String id, @RequestBody ProductDto entity) {
        ProductDto response = productClient.updateProduct(id, "12345678", entity);
        
        System.out.println("Reponse after product call: "+response.getName());
        System.out.println("Reponse after product call: "+response.getPrice());
        return ResponseEntity.ok(response);
    }


    //Testing with custom ErrorDecoder
    @GetMapping("/custom/{id}")
    public ResponseEntity<String> getOrder2(@PathVariable String id) {
        String response = productClient2.getProductById(id);
        
        System.out.println("Response from product api call with custom ErrorDecoder is: "+response);

        return ResponseEntity.ok("Order call successful: "+response);
    }
    
}
