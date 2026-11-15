package com.aditya.orderService.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.codec.ErrorDecoder;

@Configuration 
public class ProductClientConfig {
    
    @Bean 
    public ErrorDecoder myCustomErrorDecoder(){
        return new CustomProductClientErrorDecoder();
    }
}
