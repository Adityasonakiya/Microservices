package com.aditya.orderService.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "product-service2", url = "${feign.client.product-service.url}", configuration = ProductClientConfig.class)
public interface ProductClient2 {

    @GetMapping("/products/{id}")
    public String getProductById(@PathVariable("id") String id); 
}
