package com.example.capitalfloat.service;

import java.util.List;
import com.example.capitalfloat.entity.Cart;
import com.example.capitalfloat.entity.Discount;
import com.example.capitalfloat.model.DiscountDto;
import com.example.capitalfloat.model.Order;

public interface DiscountService {
  DiscountDto addDiscount(DiscountDto discount);

  Double getDiscount(Long userId);

 Order getOrderList(Long userId);
}
