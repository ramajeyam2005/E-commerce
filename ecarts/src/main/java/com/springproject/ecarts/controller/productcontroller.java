package com.springproject.ecarts.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
 
import com.springproject.ecarts.entity.product;
import com.springproject.ecarts.services.productservices;

@RestController

@RequestMapping("/api/products")
public class productcontroller {
	@Autowired
	private productservices productservices;
	
	@GetMapping
	public  Map<String,Object> getAllproducts(@RequestParam(defaultValue="0")int page,@RequestParam(defaultValue = "5")int size){
	
		return productservices.getAllproducts( page,size);
	}

	@GetMapping("/{id}")
	  public product grtProductById( @PathVariable Long id) {
	    	return productservices.grtProductById(id);
			}
	
	@GetMapping("/search")
       public List<product> searchAllproducts(@RequestParam (required = false) String category,
    		   @RequestParam (required = false) Double minprice,
    		   @RequestParam (required = false) Double maxprice,
    		   @RequestParam (required = false) String keyword,
    		   @RequestParam(required = false) Double ratings){
       
       return productservices.searchproducts(category, minprice, maxprice, keyword,ratings);
       
		
	}
	
	
}



