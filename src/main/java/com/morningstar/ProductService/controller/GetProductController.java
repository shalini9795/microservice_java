package com.morningstar.ProductService.controller;

//import java.util.ArrayList;

import java.util.List;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.morningstar.ProductService.service.ProductService;
import com.morningstar.ProductService.entity.Product;
import com.morningstar.ProductService.model.ProductDetail;

@RestController
public class GetProductController {

	/*
	@Autowired
	private ProductRepository productRepository;
	*/
	
	@Autowired 
	ProductService productService;
	/*
	@GetMapping("/api/v1.0/product/get/all")
	public ResponseEntity<List<Product>> getAllProducts(){
		
		List<Product> productList=new ArrayList<>();
		productList=productRepository.findAll();
		
		if(productList!=null && productList.size()>0){
			return new ResponseEntity<List<Product>> (productList,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<List<Product>>(productList,HttpStatus.NOT_FOUND);
		}
	}
	
	//Approach1
	@GetMapping("/api/v1.0/product/get/{productId}")
	public ResponseEntity<Product> getProductbyId(@PathVariable(name="productId") String id){
		
		Long prodId= Long.valueOf(id);
		Optional<Product> optional=productRepository.findById(prodId);
		Product product=optional.orElse(new Product());
		
		return new ResponseEntity<Product>(product,HttpStatus.OK);
		
	}
	
	
	//Approach2
		@GetMapping("/api/v1.0/product/get")
		public ResponseEntity<Product> fetchProductbyId(@RequestParam(name="productId") String id){
			
			Long prodId= Long.valueOf(id);
			Optional<Product> optional=productRepository.findById(prodId);
			Product product=optional.orElse(new Product());
			
			return new ResponseEntity<Product>(product,HttpStatus.OK);
			
		}
		*/
	
	@GetMapping("/api/v1.0/product/fetch/item/detail/{productId}")
	public ResponseEntity<ProductDetail> fetchProductAndPrice(
			@PathVariable(name="productId") final Long productId){
		
		if(productId == 0) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		System.out.println("------------------------------>");
		
		ProductDetail productDetails = productService.fetchProductDetails(productId);
		
		return new ResponseEntity<ProductDetail>(productDetails, HttpStatus.OK);
	}
	
	
	
	
	
	@GetMapping("/api/v1.0/fetch/product")
	public ResponseEntity<List<Product>> fetchProductList(@RequestParam String category){
		
		try{
			List<Product> productList = productService.fetchProductByCategory(category);
			return new ResponseEntity<List<Product>>(productList, HttpStatus.OK);
		}
		catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	@GetMapping("/api/v1.0/product/fetch/item")
	public ResponseEntity<Product> fetchProductItem(@RequestParam final Long productId){
		
		Product product = productService.fetchProductById(productId);
		
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}
	
	
	@GetMapping("/")
	public String dummy() {
		
		return "Product service up and running...";
	}
}
