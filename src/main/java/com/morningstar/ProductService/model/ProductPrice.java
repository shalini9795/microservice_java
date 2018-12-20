package com.morningstar.ProductService.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class ProductPrice {

	public Double taxPercent= 8.5; 
	
//	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private float discount_amount;
	private float discount_percent;
	private boolean is_discount_applicable;
	private float payable_amount;
	private float price_after_discount;
	private int product_id;
	private float productmrp;
	private float tax_amount;
	private float tax_percent;
}
