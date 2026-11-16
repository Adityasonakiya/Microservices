package com.aditya.orderService.config;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.loadbalancer.core.RandomLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ReactorLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.cloud.loadbalancer.support.LoadBalancerClientFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadBalancerProductClientConfig {

    @Bean
    public ReactorLoadBalancer<ServiceInstance> productClientLoadBalancer(
            LoadBalancerClientFactory factory) {
        return new RandomLoadBalancer(
                factory.getLazyProvider("productService", ServiceInstanceListSupplier.class),
                "productService");

        // 1-New RandomLoadBalancer(ServiceInstanceListSupplier, serviceId)
        // we pass serviceId because it mapped this algorithm to this service ID only.
        // So for "productService" only RandomLoadBalancer is used.

        // 2-ServiceInstanceListSupplier, is actually the one, which helps to invoke
        // Service Discovery and ask for instances of "productService"  
    }
}
