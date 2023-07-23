package com.microservice.CafeReview.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.microservice.CafeReview.model.CafeReview;
import com.microservice.CafeReview.service.CafeReviewService;

@Controller
public class CafeReviewController {

	@Autowired
	private CafeReviewService cafeReviewService;

	@PostMapping("/addCafeReview")
	public String addCafeReview(@ModelAttribute("cafeId") String cafeId,
			@ModelAttribute("cafeRating") String cafeRating, @ModelAttribute("cafeDesc") String cafeDesc) {
		CafeReview cafeReview = CafeReview.builder().cafeId(Integer.valueOf(cafeId))
				.cafeRating(Integer.valueOf(cafeRating)).cafeRemarks(cafeDesc).build();
		Optional<CafeReview> savedCafeReview= Optional.ofNullable(cafeReviewService.addCafeReview(cafeReview));
		
		if(savedCafeReview.isPresent())
			return "success";
		else
			return "failure";
	}
	
	@GetMapping("/getAllReviews")
	@ResponseBody
	public List<CafeReview> getAllCafeReviews(){
		return cafeReviewService.getAllCafeReviews();
	}
	
	@GetMapping("/getCafeReviewById/{id}")
	@ResponseBody
	public List<CafeReview> getCafeReviewById(@PathVariable("id") String cafeId){
		return cafeReviewService.getCafeReviewById(Integer.valueOf(cafeId));
	}
}
