package com.microservice.cafeinfo.service;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.microservice.cafeinfo.feignproxy.CafeReviewProxy;
import com.microservice.cafeinfo.model.CafeInfo;
import com.microservice.cafeinfo.model.CafeReview;
import com.microservice.cafeinfo.repository.CafeInfoRepository;

@Service
public class CafeInfoService {

	@Autowired
	private CafeInfoRepository cafeInfoRepository;

	public CafeInfo addCafe(CafeInfo cafeInfo) {

		return cafeInfoRepository.save(cafeInfo);
	}

	public Optional<CafeInfo> getByCafeId(Integer cafeId) {
		return cafeInfoRepository.findById(cafeId);

	}

	public List<CafeInfo> getAllCafes() {

		return cafeInfoRepository.findAll();
	}

	@Value("${pivotal.cafereviewservice.name}")
	protected String cafeReviewService;

	@Autowired
	private CafeReviewProxy cafeReviewProxy;
	
	public ModelAndView getCafeDetailsAndReviewsById(Integer cafeId) {

		System.out.println("Model ");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("cafeInfo", this.getByCafeId(cafeId).get());

		List<CafeReview> cafeReviewList = cafeReviewProxy.getReviewList(cafeId);
		System.out.println(cafeReviewList);
		modelAndView.addObject("cafeReviewList", cafeReviewList);
		modelAndView.setViewName("cafeAll");

		return modelAndView;
	}

}
