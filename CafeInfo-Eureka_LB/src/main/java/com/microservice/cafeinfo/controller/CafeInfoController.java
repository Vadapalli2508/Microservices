package com.microservice.cafeinfo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.microservice.cafeinfo.model.CafeInfo;
import com.microservice.cafeinfo.service.CafeInfoService;

@Controller
public class CafeInfoController {

	@Autowired
	private CafeInfoService cafeInfoService;

	@PostMapping("/addCafe")
	public String addCafe(@ModelAttribute("CafeName") String cafeName, @ModelAttribute("CafeDesc") String cafeDesc,
			ModelMap model) {
		
		model.addAttribute("cafeName", cafeName);
		model.addAttribute("cafeDesc", cafeDesc);
		CafeInfo cafeInfo = CafeInfo.builder().cafeName(cafeName).cafeDesc(cafeDesc).build();
		Optional<CafeInfo> savedCafeInfo = Optional.ofNullable(cafeInfoService.addCafe(cafeInfo));
		if (savedCafeInfo.isPresent())
			return "success";
		else
			return "fail";
	}

	@GetMapping("/getByCafeId/{id}")
	@ResponseBody
	public Optional<CafeInfo> getCafeById(@PathVariable("id") Integer cafeId) {

		return cafeInfoService.getByCafeId(cafeId);
	}

	@GetMapping("/getAllCafes")
	@ResponseBody
	public List<CafeInfo> getAllCafes() {
		return cafeInfoService.getAllCafes();
	}

	@GetMapping("/getCafeInfoCount")
	@ResponseBody
	public Integer getCafeInfoCount() {
		return getAllCafes().size();
	}

	@GetMapping("getCafeDetailsAndReviewsById/{cafeId}")
	public ModelAndView getCafeDetailsAndReviewsById(@PathVariable("cafeId") String cafeId) {
		System.out.println("Controller");
		return cafeInfoService.getCafeDetailsAndReviewsById(Integer.valueOf(cafeId));
	}
	
}
