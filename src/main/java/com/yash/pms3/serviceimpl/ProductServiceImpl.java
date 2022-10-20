package com.yash.pms3.serviceimpl;

import java.util.List;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.pms3.dao.ProductDao;
import com.yash.pms3.exceptions.ResourceNotFoundException;
import com.yash.pms3.model.Product;
import com.yash.pms3.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductDao productdao;
	
	@Override
	public List<Product> getDetails() 
		{	
			return this.productdao.findAll();
		}
	
	public Optional<Product> getDetailsById(Long id) throws ResourceNotFoundException
		{
			if(this.productdao.existsById(id)) {
			Optional<Product> data=this.productdao.findById(id);
			return data;
			}
			else
				throw new ResourceNotFoundException("Product", "Id", id);
		}
	
	public Product save(Product data)
		{
			this.productdao.save(data);
			return data;
		}
	
	public void delete(Long delid) throws ResourceNotFoundException
		{
		if(this.productdao.existsById(delid))
			{
				this.productdao.deleteById(delid);
			}
			else
				throw new ResourceNotFoundException("Product", "Id", delid);
			
		}
}
