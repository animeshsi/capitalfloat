package com.example.capitalfloat.service;

import java.util.List;
import com.example.capitalfloat.entity.Cart;
import com.example.capitalfloat.entity.Product;
import com.example.capitalfloat.model.ProductDto;

public interface ProductService {
  ProductDto addProduct(ProductDto productDto);

  Cart addCart(Cart cart);

  List<Cart> getProduct(Long userId);
}
