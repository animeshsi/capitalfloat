package com.example.capitalfloat.controller;

import com.example.capitalfloat.entity.Discount;
import com.example.capitalfloat.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DiscountController {

  @Autowired
  DiscountService discountService;

  @PostMapping("/discount")
  public @ResponseBody
  Discount createDiscount(@RequestBody Discount discount)  {
    return discountService.addDiscount(discount);
  }

  @GetMapping("/discount/{userId}")
  public Double getDiscount(@PathVariable(value = "userId") Long userId)  {
    return discountService.getDiscount(userId);
  }
}
