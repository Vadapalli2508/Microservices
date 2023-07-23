package com.microservice.cafeinfo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CafeReview {
	
	@Id
	@GeneratedValue
	private int reviewId;
	private int cafeId;
	private int cafeRating;
	private String cafeRemarks;
	

}
