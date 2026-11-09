package com.aditya.orderService.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController 
@RequestMapping("/order")
public class OrderController {

    private final RestTemplate restTemplate;

    public OrderController(RestTemplate restTemplate){
        this.restTemplate=restTemplate;
    }
    
    //if want to get just body, use this
    @GetMapping("/{id}")
    public ResponseEntity<String> orderIt(@PathVariable String id) {
        
        String response=restTemplate.getForObject("http://localhost:8082/products/19", String.class);
        System.out.println("Response from product -> "+response);

        return ResponseEntity.ok("Order done.");
    }

    //if want to get whole response, use this
    @GetMapping("shoes/{id}")
    public ResponseEntity<String> orderShoes(@PathVariable String id) {
        
        ResponseEntity<String> response=restTemplate.getForEntity("http://localhost:8082/products/shoes/10", String.class);
        System.out.println("Response from shoe -> "+response);
        System.out.println("Status code from shoe -> "+response.getStatusCode());
        System.out.println("Body from shoe -> "+response.getBody());

        return ResponseEntity.ok("Order done.");
    }

    @PostMapping
    public String addOrder() {
        
        String request="New Product 234567";
        String response=restTemplate.postForObject("http://localhost:8082/products", request, String.class);

        System.out.println("Response from product for post call -> "+response);
        return "post request success";
    }

    //can do same postForEntity as well to get full entity in response
}
