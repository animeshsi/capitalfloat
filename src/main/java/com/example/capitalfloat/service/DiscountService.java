package com.example.capitalfloat.service;

import com.example.capitalfloat.entity.Discount;
import com.example.capitalfloat.model.DiscountDto;

public interface DiscountService {
  DiscountDto addDiscount(DiscountDto discount);

  Double getDiscount(Long userId);
}
