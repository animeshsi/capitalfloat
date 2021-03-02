package com.example.capitalfloat.mapper;

import java.util.function.Function;
import com.example.capitalfloat.entity.Discount;
import com.example.capitalfloat.model.DiscountDto;

public class DiscountDtoToDiscountMapper implements Function<DiscountDto, Discount> {
  @Override
  public Discount apply(final DiscountDto discountDto) {

    if (discountDto == null) {
      return null;
    }

    return Discount.builder().amount(discountDto.getAmount()).
        discountCatagory(discountDto.getDiscountCatagory()).isExpired(discountDto.isExpired()).
        product(discountDto.getProduct()).quantity(discountDto.getQuantity())
        .build();

  }
}
