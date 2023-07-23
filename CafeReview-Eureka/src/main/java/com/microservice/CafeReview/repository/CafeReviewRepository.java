package com.microservice.CafeReview.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservice.CafeReview.model.CafeReview;

@Repository
public interface CafeReviewRepository extends JpaRepository<CafeReview, Integer> {

	List<CafeReview> findAllByCafeId(Integer cafeId);

}
