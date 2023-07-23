package com.microservice.CafeReview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CafeReviewApplication {

	public static void main(String[] args) {
		SpringApplication.run(CafeReviewApplication.class, args);
	}

}
