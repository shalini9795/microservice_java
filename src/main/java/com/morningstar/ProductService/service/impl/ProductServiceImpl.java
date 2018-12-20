package com.morningstar.ProductService.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.morningstar.ProductService.entity.Product;
import com.morningstar.ProductService.exception.ProductException;
import com.morningstar.ProductService.model.ProductDetail;
import com.morningstar.ProductService.model.ProductPrice;
import com.morningstar.ProductService.repository.ProductRepository;
import com.morningstar.ProductService.service.ProductService;
import com.morningstar.ProductService.service.template.PriceTemplate;



@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private PriceTemplate priceTemplate;
	
	@Override
	public Product fetchProductById(final Long productId) {
		
		Optional<Product> optional = productRepository.findById(productId);
		
		return optional.orElse(new Product());
	}

	@Override
	public ProductDetail fetchProductDetails(Long productId) {
		
		// Fetch product details from DB
		Product product = fetchProductById(productId);
		
		// Fetch Product's price from PriceService
		ProductPrice productPrice = priceTemplate.fetchPrice(productId);
		
		return new ProductDetail(product, productPrice);		
	}

	
	@Override
	public List<Product> fetchProductByCategory(String category) {
		
		Optional<List<Product>> optional = productRepository.findByCategory(category);
		
		if(optional.isPresent()) {
			return optional.get();
		}
		else {
			throw new ProductException("Product Not available for Category: " + category);
		}
	}

	@Override
	public Product addProduct(Product product) {
		
		return productRepository.save(product);
	}
}
