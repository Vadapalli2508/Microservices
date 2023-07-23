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
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CafeInfo {

	@Id
	@GeneratedValue
	private int cafeId;
	private String cafeName;
	private String cafeDesc;
}
