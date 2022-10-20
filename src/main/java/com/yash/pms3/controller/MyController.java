 package com.yash.pms3.controller;

import java.util.List;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yash.pms3.model.Product;
import com.yash.pms3.service.ProductService;

@RestController
public class MyController {
	
	
		@Autowired
		private ProductService product;
		
		@GetMapping("/hello")
	    public String hello()
	    {
	        return "Hello";
	    }
		
		@GetMapping("/details")
		public ResponseEntity<List<Product>> getAllProduct() throws Exception
		{
			List<Product> list= this.product.getDetails();
			return new ResponseEntity<List<Product>>(list, new HttpHeaders(),HttpStatus.OK);
		}
		
		@GetMapping("/details/{id}")
		public ResponseEntity<Optional<Product>> getDetailsById(@PathVariable(name = "id") Long id) throws Exception
			{
				Optional<Product> p=this.product.getDetailsById(id);
				
				return new ResponseEntity<Optional<Product>>(p,new HttpHeaders(),HttpStatus.OK);
			}
		@PutMapping("/details")
		public ResponseEntity<Product> addDetails(@Valid @RequestBody Product data) throws Exception
			{
				Product p= this.product.save(data);
				return new ResponseEntity<Product>(p, new HttpHeaders(), HttpStatus.CREATED);
			}
		
		@DeleteMapping("/details/{id}")
		public ResponseEntity<String> delDetails(@PathVariable(name ="id") Long id) throws Exception
			{
				this.product.delete(id);
				return new ResponseEntity<String>("Deleted", HttpStatus.OK);
			}
}
