package com.springproject.ecarts.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

@Entity
public class productreviews {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Min(value = 1)
	@Max(value = 5)
    private Double ratings;
	private String comment;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Double getRatings() {
		return ratings;
	}
	public void setRatings(Double ratings) {
		this.ratings = ratings;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public productreviews(long id, @Min(1) @Max(5) Double ratings, String comment) {
		super();
		this.id = id;
		this.ratings = ratings;
		this.comment = comment;
	}
	public productreviews() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@ManyToOne()
	@JoinColumn(name="product_id")
//	@JsonIgnore                       alternative use  dtoclass to manage
	private product product;
	public product getProduct() {
		return product;
	}
	public void setProduct(product product) {
		this.product = product;
	}
	
	





}
