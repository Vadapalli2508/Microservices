package com.microservice.cafeinfo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.microservice.cafeinfo.model.CafeInfo;
import com.microservice.cafeinfo.model.CafeReview;
import com.microservice.cafeinfo.repository.CafeInfoRepository;

@Service
public class CafeInfoService {

	@Autowired
	private CafeInfoRepository cafeInfoRepository;
	@Autowired
	private RestTemplate restTemplate;

	public CafeInfo addCafe(CafeInfo cafeInfo) {

		return cafeInfoRepository.save(cafeInfo);
	}

	public Optional<CafeInfo> getByCafeId(Integer cafeId) {
		return cafeInfoRepository.findById(cafeId);

	}

	public List<CafeInfo> getAllCafes() {

		return cafeInfoRepository.findAll();
	}

	public ModelAndView getCafeDetailsAndReviewsById(Integer cafeId) {
		
		System.out.println("Model ");
		ModelAndView modelAndView= new ModelAndView();
		modelAndView.addObject("cafeInfo", this.getByCafeId(cafeId).get());
		
		String url= "http://localhost:8088/getCafeReviewById/"+cafeId;
		System.out.println("URL :"+ url);
		List<CafeReview> cafeReviewList= restTemplate.getForObject(url, List.class);
		System.out.println(cafeReviewList);
		modelAndView.addObject("cafeReviewList",cafeReviewList);
		modelAndView.setViewName("cafeAll");
		
		return modelAndView;
	}

}
