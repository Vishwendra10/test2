package com.yash.pms3.service;

import java.util.List;

import java.util.Optional;

import com.yash.pms3.exceptions.ResourceNotFoundException;
import com.yash.pms3.model.Product;

public interface ProductService {
	
	public List<Product> getDetails();
	public Optional<Product> getDetailsById(Long id) throws ResourceNotFoundException;
	public Product save(Product data);
	public void delete(Long id) throws ResourceNotFoundException;
	

}
