package com.microservice.cafeinfo.feignproxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.microservice.cafeinfo.model.CafeReview;

@FeignClient(value = "CafeReview-Service")
public interface CafeReviewProxy {

	@GetMapping("/getCafeReviewById/{cafeId}")
	public List<CafeReview> getReviewList(@PathVariable Integer cafeId);
	
	

}
