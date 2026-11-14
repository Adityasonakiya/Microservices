package com.aditya.orderService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.autoconfigure.JacksonProperties.Json;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

import com.aditya.orderService.dto.ProductDto;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController 
@RequestMapping("/orders")
public class OrderController {
    
    @Autowired 
    RestClient restClient;

    @GetMapping("/{id}")
    public ResponseEntity<String> getOrder(@PathVariable String id) {
        
        // String response= restClient.get()
        //                 .uri("http://localhost:8082/products/"+id)
        //                 .retrieve()
        //                 .body(String.class);

        String response2= restClient.get()
                        .uri("http://localhost:8082/products/"+id)
                        .accept(MediaType.APPLICATION_JSON)
                        .header("X-Custom-Header", "23456")
                        .retrieve()
                        .body(String.class);
        
                        
        System.out.println("Response recieved from product service: "+response2);
        return ResponseEntity.ok("order call successful -> "+response2);                        
    }


    @PostMapping
    public ResponseEntity<ProductDto> checkPost(@RequestBody ProductDto requestDto) {
        
        ResponseEntity<ProductDto> response=restClient.post()
                            .uri("http://localhost:8082/products")
                            .accept(MediaType.APPLICATION_JSON)
                            .body(requestDto)
                            .retrieve()
                            .toEntity(ProductDto.class);

        System.out.println("Whole response -> "+response);        
        System.out.println("Response body -> "+response.getBody());        
        return response;                            
    }
    
    
}
