package com.aditya.orderService.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.aditya.orderService.dto.ProductDto;

@FeignClient(name = "product-service", url = "${feign.client.product-service.url}")
public interface ProductClient {

    @GetMapping("/products/{id}")
    String getProductById(@PathVariable("id") String id);
    // no need to write any logic or anything, it will implement this
    // "getProductById" at runtime and make us communicate with product service

    @PutMapping(value = "/products/{id}", consumes = "application/json")
    ProductDto updateProduct(@PathVariable("id") String id,
            @RequestHeader("X-Testing-ID") String uniqueId, @RequestBody ProductDto updatedProduct);
}
