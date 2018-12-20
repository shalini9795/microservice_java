package com.morningstar.ProductService.entity;


import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="product",schema="schema_shopping")
@Data
public class Product {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String category;
	private String model;
	private String name;
	private String status;
	private int quantity;	
}
