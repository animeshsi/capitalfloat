package com.example.capitalfloat.service.impl;


import java.util.List;
import com.example.capitalfloat.entity.Cart;
import com.example.capitalfloat.entity.Product;
import com.example.capitalfloat.mapper.ProductDtoToProductMapper;
import com.example.capitalfloat.mapper.ProductToProductDtoMapper;
import com.example.capitalfloat.model.ProductDto;
import com.example.capitalfloat.repository.CartRepository;
import com.example.capitalfloat.repository.ProductRepository;
import com.example.capitalfloat.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

  @Autowired
  ProductRepository productRepository;

  @Autowired
  CartRepository cartRepository;

  @Override
  public ProductDto addProduct(ProductDto productDto) {
    Product product = new ProductDtoToProductMapper().apply(productDto);
    return new ProductToProductDtoMapper().apply(productRepository.save(product));
  }

  @Override
  public Cart addCart(Cart cart) {
    return cartRepository.save(cart);
  }

  @Override
  public List<Cart> getProduct(Long userId) {
    return cartRepository.findByUserId(userId);
  }
}
