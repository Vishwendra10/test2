package com.yash.pms3.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yash.pms3.model.Product;

public interface ProductDao extends JpaRepository<Product, Long> {
	

}
