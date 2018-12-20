package com.morningstar.ProductService.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.morningstar.ProductService.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	Optional<List<Product>> findByCategory(String category);
}
