package com.aditya.orderService.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.aditya.orderService.client.ProductClient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired 
    RestTemplate restTemplate;

    @Value("${product.service.baseurl}")
    String productBaseUrl;


    @GetMapping("1/{id}")
    public String getOrder(@PathVariable String id) {

        // Now, we don’t need DiscoveryClient here. 
        String response = restTemplate.getForObject(productBaseUrl + "/products/" + id, String.class);
        System.out.println("Response from product api: " + response);

        return "Response from product class: " + response;
    }

    
    // @GetMapping("2/{id}")
    // public String getOrder2(@PathVariable String id) {

    //     String response=productClient.getProductById(id);

    //     System.out.println("Response from product api: " + response);

    //     return "Response from product class: " + response;
    // }


}
