package com.example.capitalfloat.repository;

import com.example.capitalfloat.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
