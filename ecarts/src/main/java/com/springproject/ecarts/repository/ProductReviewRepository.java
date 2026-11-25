package com.springproject.ecarts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springproject.ecarts.entity.productreviews;

public interface ProductReviewRepository  extends JpaRepository<productreviews, Long>{
	
	

}
