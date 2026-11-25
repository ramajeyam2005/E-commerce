package com.springproject.ecarts.Dto;

import java.util.List;

import com.springproject.ecarts.entity.productimage;
import com.springproject.ecarts.entity.productreviews;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public class productDto {


		
		private  Long id;
		
		
		private String name;
	
		private Double price;
		
	
		private String description;
		
		private String category;
		
		
	   	private Double ratings=0.0;
	   	
	  
		private String seller;
	   	
	  
		private Integer stock;
	   	
		private Integer numofreviews=0;
		
	
		private List<productimage>images;
		
		
		private List<ProductReviewDto>reviews;
		
		
		public List<ProductReviewDto> getReviews() {
			return reviews;
		}
		public void setReviews(List<ProductReviewDto> reviewDtos) {
			this.reviews = reviewDtos;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Double getPrice() {
			return price;
		}
		public void setPrice(Double price) {
			this.price = price;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		
		public String getCategory() {
			return category;
		}
		public void setCategory(String category) {
			this.category = category;
		}
		public Double getRatings() {
			return ratings;
		}
		public void setRatings(Double ratings) {
			this.ratings = ratings;
		}
		public String getSeller() {
			return seller;
		}
		public void setSeller(String seller) {
			this.seller = seller;
		}
		public Integer getStock() {
			return stock;
		}
		public void setStock(Integer stock) {
			this.stock = stock;
		}
		public Integer getNumofreviews() {
			return numofreviews;
		}
		public void setNumofreviews(Integer numofreviews) {
			this.numofreviews = numofreviews;
		}
		public void product(Long id, String name, Double price, String description,String category, Double ratings, String seller, Integer stock) {
			this.id = id;
			this.name = name;
			this.price = price;
			this.description = description;
			this.category=category;
			this.ratings = ratings;
			this.seller = seller;
			this.stock = stock;
			
		}
	
		
}
