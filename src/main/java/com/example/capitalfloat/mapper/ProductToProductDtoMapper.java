package com.example.capitalfloat.mapper;

import java.util.function.Function;
import com.example.capitalfloat.entity.Product;
import com.example.capitalfloat.model.ProductDto;

public class ProductToProductDtoMapper implements Function<Product, ProductDto> {

  @Override
  public ProductDto apply(final Product product) {

    if (product == null) {
      return null;
    }

    return ProductDto.builder().category(product.getCategory()).price(product.getPrice())
        .productName(product.getProductName()).quantity(product.getQuantity()).id(product.getId())
        .build();

  }
}
