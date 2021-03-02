package com.example.capitalfloat.mapper;

import java.util.function.Function;
import com.example.capitalfloat.entity.Discount;
import com.example.capitalfloat.model.DiscountDto;

public class DiscountToDiscountDtoMapper implements Function<Discount, DiscountDto> {

  @Override
  public DiscountDto apply(final Discount discount) {

    if (discount == null) {
      return null;
    }

    return DiscountDto.builder().quantity(discount.getQuantity()).amount(discount.getAmount())
        .discountCatagory(discount.getDiscountCatagory()).isExpired(discount.isExpired())
        .build();

  }
}
