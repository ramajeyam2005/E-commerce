package com.springproject.ecarts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.springproject.ecarts.entity.product;

public interface productrepository  extends JpaRepository<product, Long>,JpaSpecificationExecutor<product>{
	

}
