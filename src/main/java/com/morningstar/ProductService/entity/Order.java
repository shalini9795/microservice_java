package com.morningstar.ProductService.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name="Order", schema="schema_shopping")
public class Order {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	
}
