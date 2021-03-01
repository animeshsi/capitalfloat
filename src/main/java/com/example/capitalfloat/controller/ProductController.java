package com.example.capitalfloat.controller;

import java.util.LinkedHashMap;
import java.util.List;
import com.example.capitalfloat.entity.Cart;
import com.example.capitalfloat.entity.Product;
import com.example.capitalfloat.model.ProductDto;
import com.example.capitalfloat.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

  @Autowired
  ProductService productService;

  @PostMapping("/product")
  public @ResponseBody
  ProductDto createProduct( @RequestBody ProductDto productDto)  {
    return productService.addProduct(productDto);
  }
  @PostMapping("/cart")
  public @ResponseBody
  Cart createCart(@RequestBody Cart cart)  {
    return productService.addCart(cart);
  }

  @GetMapping("/cart/{userId}")
  public @ResponseBody
  List<Cart> getProduct(@PathVariable(value = "userId") Long userId)  {
    return productService.getProduct(userId);
  }

}
