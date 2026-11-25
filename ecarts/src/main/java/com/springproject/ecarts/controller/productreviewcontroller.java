package com.springproject.ecarts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springproject.ecarts.Dto.ProductReviewDto;
import com.springproject.ecarts.services.productservices;

@RestController
@RequestMapping("/api/products/reviews")
public class productreviewcontroller {
	
	@Autowired
	private productservices productservices;

	@PostMapping
	public ResponseEntity<?> addreview(@RequestBody ProductReviewDto reviewDto) {
		productservices.addreview(reviewDto);
		
		return ResponseEntity.status(HttpStatus.CREATED).body("review added");
		
	}
}
