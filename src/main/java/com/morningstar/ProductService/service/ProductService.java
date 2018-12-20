package com.morningstar.ProductService.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.morningstar.ProductService.entity.Product;
import com.morningstar.ProductService.model.ProductDetail;





@Service
public interface ProductService {

	Product addProduct(Product product);
	
	Product fetchProductById(final Long id);
	
	ProductDetail fetchProductDetails(final Long productId);
	
	List<Product> fetchProductByCategory(String category);
}
