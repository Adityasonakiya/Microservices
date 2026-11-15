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

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    DiscoveryClient discoveryClient;

    @Autowired 
    ProductClient productClient;

    // 1-Checking service Discovery with RestTemplate
    // Here you need to write load balancing logic yourself
    // We are just fetching first instance as load balancing
    @GetMapping("1/{id}")
    public String getOrder(@PathVariable String id) {
        RestTemplate restTemplate = new RestTemplate();

        // 1-Fetching the instances of "product-service"
        List<ServiceInstance> instances = discoveryClient.getInstances("productService");
        // 2-load balancer logic to choose a particular instance.
        URI uri = instances.get(0).getUri();
        System.out.println("Instances from discovery client: " + instances);

        String response = restTemplate.getForObject(uri + "/products/" + id, String.class);
        System.out.println("Response from product api: " + response);

        return "Response from product class: " + response;
    }

    // 2-Service Discovery with feign client
    // So with FeignClient, loadBalancing is handled automatically and by framework.
    // We need to provide the Load Balancer dependency too, apart from
    // "spring-cloud-starter-netflix-eureka-client"
    @GetMapping("2/{id}")
    public String getOrder2(@PathVariable String id) {

        String response=productClient.getProductById(id);

        System.out.println("Response from product api: " + response);

        return "Response from product class: " + response;
    }


}
