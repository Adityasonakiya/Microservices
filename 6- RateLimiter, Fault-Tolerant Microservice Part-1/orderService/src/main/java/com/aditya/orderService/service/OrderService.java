package com.aditya.orderService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aditya.orderService.client.ProductClient;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;

@Service
public class OrderService {

    @Autowired
    ProductClient productClient;

    // @RateLimiter-> from this annotation only, rate limiting is integrated here
    // Here Resilience4j uses Semaphore-based implementation using a Token
    // Bucket-like interval algorithm by default.
    // Same case goes with RestTemplate and Rest Client, just annotate them with
    // this, and write its configuration accordingly in app.properties
    @RateLimiter(name = "productRateLimiter", fallbackMethod = "rateLimitedFallback")
    public void invokeProductAPI(String id) {
        String response = productClient.getProductById(id);
        System.out.println("Response got from product API: " + response);
    }

    // fallback method's return type and parameter(additionally only Throwable need
    // to add more) should match with the original method, else default fallback
    // method provided by RateLimiter framework will get invoked.
    public void rateLimitedFallback(String id, Throwable t) {
        System.out.println("Rate limit exceed, Try later.");
    }
}
