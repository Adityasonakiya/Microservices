package com.aditya.orderService.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration 
public class AppConfig {
    
    //if just want to use basic 
    @Bean 
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    //if want to set timeouts
    // @Bean 
    // public RestTemplate restTemplate(){

    //     SimpleClientHttpRequestFactory factory= new SimpleClientHttpRequestFactory();

    //     //set in milliseconds
    //     factory.setConnectTimeout(1000); //1 sec for connection Timeout
    //     factory.setReadTimeout(5000);   //5 sec for response Timeout

    //     return new RestTemplate();
    // }
}
