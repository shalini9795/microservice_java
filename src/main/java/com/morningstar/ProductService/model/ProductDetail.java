package com.morningstar.ProductService.model;

import com.morningstar.ProductService.entity.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class ProductDetail {

	private Product product;
	
	private ProductPrice productPrice;
}
