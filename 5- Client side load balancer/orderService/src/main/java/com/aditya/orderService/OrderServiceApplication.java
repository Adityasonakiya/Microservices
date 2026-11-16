package com.aditya.orderService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.aditya.orderService.config.LoadBalancerProductClientConfig;

@SpringBootApplication
@EnableFeignClients
@LoadBalancerClient(name = "productService", configuration = LoadBalancerProductClientConfig.class)
public class OrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}

	// @LoadBalancerClient is only needed when we want another load balancer algo
	// instead of Default RoundRobinLoadBalancer, we can override it in
	// configuration from here, else no need to write this annotation
	// Spring Cloud Load Balancer supports only 2 algorithms i.e. RoundRobin and
	// Random
	// sIf we want different algorithm like Weighted, Least Connection etc. then
	// either we need to write custom implementation or switch to service mesh like
	// Istio with Side car.

	// same goes with feign client as well, if we don't wanna use RoundRobin, use
	// @LoadBalancerClient
}
