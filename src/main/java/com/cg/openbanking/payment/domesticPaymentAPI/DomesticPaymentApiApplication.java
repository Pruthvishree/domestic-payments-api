package com.cg.openbanking.payment.domesticPaymentAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient
@EnableHystrixDashboard
@EnableCircuitBreaker

@RefreshScope
public class DomesticPaymentApiApplication  {
	public static void main(String[] args) {
		SpringApplication.run(DomesticPaymentApiApplication.class, args);
	}
}