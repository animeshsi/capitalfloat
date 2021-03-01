package com.example.capitalfloat.repository;

import java.util.List;
import com.example.capitalfloat.entity.Cart;
import com.example.capitalfloat.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
  List<Cart> findByUserId(Long userId);
}
