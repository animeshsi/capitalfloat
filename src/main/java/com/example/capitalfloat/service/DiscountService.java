package com.example.capitalfloat.service;

import com.example.capitalfloat.entity.Discount;

public interface DiscountService {
  Discount addDiscount(Discount discount);

  Double getDiscount(Long userId);
}
