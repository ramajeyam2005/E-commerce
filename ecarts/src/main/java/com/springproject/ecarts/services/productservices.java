	package com.springproject.ecarts.services;

	import java.util.HashMap;
	import java.util.List;
	import java.util.Map;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.data.domain.Page;
	import org.springframework.data.domain.PageRequest;
	import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.springproject.ecarts.Dto.ProductReviewDto;
import com.springproject.ecarts.entity.product;
import com.springproject.ecarts.entity.productreviews;
import com.springproject.ecarts.repository.ProductReviewRepository;
import com.springproject.ecarts.repository.productrepository;
import com.springproject.ecarts.spec.productspecification;

	@Service
	public class productservices {

	    @Autowired
	    private productrepository productrepository;
	    
	    @Autowired
	    private ProductReviewRepository productReviewRepository;
	    
//	    public List<product> geyAllproducts(){
//			
//	    	List<product> products=	productrepository.findAll();
//	    	return products;

	    public Map<String, Object> getAllproducts(int page, int size) {  //getAll product method

	        Pageable pageable = PageRequest.of(page, size);

	        
	        Page<product> products =
	        		productrepository.findAll(pageable);

	        Map<String, Object> response = new HashMap<>();

	        response.put("products", products.getContent());

	          response.put("totalProducts", products.getTotalElements());

	        return response;
	    }
	    
	  public product grtProductById(long id) {                               //getbyid method
		  return productrepository.findById(id).orElseThrow(()->new RuntimeException("product not found in the id"));
		
	}
	  
	  public List<product> searchproducts( String category,Double minprice,Double maxprice,String keyword,Double ratings) {
		  Specification<product> Spec=Specification.where(productspecification.hascategory(category))
				  . and (productspecification.pricebetween(minprice, maxprice))
				  .and(productspecification.hasNameOrDescriptionLike(keyword))
				  .and(productspecification.ratingGreaterThan(ratings));
		
		  return productrepository.findAll(Spec);
	}
	    
	    
	    

		public Map<String, Object> getAllproduct() {
			// TODO Auto-generated method stub
			return null;
		}

		public void addreview(ProductReviewDto reviewDto) {
			// TODO Auto-generated method stub
		product product	 = productrepository.findById(reviewDto.getProductId()).orElseThrow( ()-> new RuntimeException("product not found"));
			productreviews review = new productreviews();
			review.setComment(reviewDto.getComment());
			review.setRatings(reviewDto.getRatings());
			review.setProduct(product);
			productReviewRepository.save(review);
		}
	}