package com.microservice.CafeReview.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservice.CafeReview.model.CafeReview;
import com.microservice.CafeReview.repository.CafeReviewRepository;

@Service
public class CafeReviewService {

	@Autowired
	private CafeReviewRepository cafeReviewRepository;

	public CafeReview addCafeReview(CafeReview cafeReview) {

		return cafeReviewRepository.save(cafeReview);
	}

	public List<CafeReview> getAllCafeReviews() {

		return cafeReviewRepository.findAll();
	}

	@Autowired
	private Resilience4JCircuitBreakerFactory circuitBreakerFactory;
	
	

	public List<CafeReview> getCafeReviewById(Integer integer) {

		RestTemplate restTemplate= new RestTemplate();
		String url="";
		
		CircuitBreaker circuitBreaker = circuitBreakerFactory.create("Generate Circuit Breaker");
		return (List<CafeReview>) circuitBreaker.run(()->restTemplate.getForObject(url, List.class), throwable-> getDefaultReviews());

	}

	private List<CafeReview> getDefaultReviews() {
		List<CafeReview> defaultReviews= new ArrayList<CafeReview>();
		defaultReviews.add(CafeReview.builder().cafeId(1).cafeRating(0).cafeRemarks("default1").build());
		defaultReviews.add(CafeReview.builder().cafeId(1).cafeRating(0).cafeRemarks("default2").build());
		defaultReviews.add(CafeReview.builder().cafeId(1).cafeRating(0).cafeRemarks("default3").build());
		return defaultReviews;
	}

}
