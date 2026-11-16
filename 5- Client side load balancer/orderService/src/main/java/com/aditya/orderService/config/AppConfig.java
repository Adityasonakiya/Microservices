package com.aditya.orderService.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    // With this annotation, framework start intercepting the request, call Service
    // Discovery, get instances & apply load balancing algorithm.
    @Bean
    @LoadBalanced
    public RestTemplate restTemplateObj() {
        return new RestTemplate();
    }
}
