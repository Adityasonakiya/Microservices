package com.aditya.orderService.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.aditya.orderService.client.ProductClient;
import com.aditya.orderService.service.OrderService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired 
    OrderService orderService;
    
    @GetMapping("/{id}")
    public void getOrder(@PathVariable String id) {
        orderService.invokeProductAPI(id);
    }


}
