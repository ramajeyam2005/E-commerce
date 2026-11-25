package com.springproject.ecarts.spec;

import org.springframework.data.jpa.domain.Specification;

import com.springproject.ecarts.entity.product;

public class productspecification {
	
	public static  Specification<product> hascategory(String category) {
		
		return (root,query,cb) -> category ==null? null :cb.equal(root.get("category"),category);
		
	}
	
	public static Specification<product> pricebetween(Double min,Double max){
		
		return (root,query,cb)->{
			if(min==null && max==null) return null;
			if(min ==null) return cb.lessThanOrEqualTo(root.get("price"), max);
			if(max ==null) return cb.greaterThanOrEqualTo(root.get("price"), min);
			return cb.between(root.get("price"), min, max);
		};
	}
	
	public static Specification<product> hasNameOrDescriptionLike(String keyword){
		return (root,query,cb)->{
			if(keyword == null || keyword.isEmpty()) return null;
					return cb.or(
					cb.like(root.get("name"),"%"+keyword.toLowerCase()+"%"),
					cb.like(root.get("description"),"%"+keyword.toLowerCase()+"%")
					);
		} ;
	}
	
	public static Specification<product> ratingGreaterThan(Double ratings){
		return (root,query,cb)->{
		return	cb.greaterThanOrEqualTo(root.get("ratings"), ratings);
		};
	}

}
