package com.example.capitalfloat.repository;

import java.util.List;
import com.example.capitalfloat.entity.Cart;
import com.example.capitalfloat.entity.Discount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscountRepository extends JpaRepository<Discount, Long> {
//  List<Discount> findAllByProductId(List<Long> productId);

  List<Discount> findByProductIdIn(List<Long> productIds);
}
