package com.microservice.CafeReview.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	public List<CafeReview> getCafeReviewById(Integer integer) {
		
		return cafeReviewRepository.findAllByCafeId(integer);
	}

}
