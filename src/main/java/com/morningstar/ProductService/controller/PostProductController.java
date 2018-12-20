package com.morningstar.ProductService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.morningstar.ProductService.entity.Product;
import com.morningstar.ProductService.service.ProductService;

@RestController
public class PostProductController {

		@Autowired
		ProductService productService;
		
		@PostMapping("/api/v1.0/product/add")
		public ResponseEntity<Product> addProduct(@RequestBody Product product){
			
			Product prd = productService.addProduct(product);
			
			return new ResponseEntity<Product>(prd, HttpStatus.OK);
		}
	
}
