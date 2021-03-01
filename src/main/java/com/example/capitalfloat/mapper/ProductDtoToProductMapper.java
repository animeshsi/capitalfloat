package com.example.capitalfloat.mapper;

import java.util.function.Function;
import com.example.capitalfloat.entity.Product;
import com.example.capitalfloat.model.ProductDto;


public class ProductDtoToProductMapper implements Function<ProductDto, Product> {

    @Override
    public Product apply(final ProductDto productDto) {

        if (productDto == null) {
            return null;
        }

        return Product.builder().category(productDto.getCategory()).price(productDto.getPrice())
            .quantity(productDto.getQuantity()).productName(productDto.getProductName())
                .build();

    }

}
