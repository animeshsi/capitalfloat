package com.example.capitalfloat.service.impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import com.example.capitalfloat.entity.Cart;
import com.example.capitalfloat.entity.Discount;
import com.example.capitalfloat.repository.CartRepository;
import com.example.capitalfloat.repository.DiscountRepository;
import com.example.capitalfloat.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiscountServiceImpl implements DiscountService {

  @Autowired
  DiscountRepository discountRepository;

  @Autowired
  CartRepository cartRepository;


  @Override
  public Discount addDiscount(Discount discount) {
    return discountRepository.save(discount);
  }

  @Override
  public Double getDiscount(Long userId) {
    List<Cart> list = cartRepository.findByUserId(userId);
    Double ans = 0.0;
    List<Long> productIds = list.stream().map(cart -> cart.getProduct().getId()).
        collect(Collectors.toList());
    List<Discount> discountList = discountRepository.findByProductIdIn(productIds);
    Map<Object, Discount> hashMap = discountList.stream().collect(Collectors.toMap
        (discount -> discount.getProduct().getId(), discount -> discount));
    for (Cart cart : list) {
      if (hashMap.containsKey(cart.getProduct().getId())) {
        Discount discount = hashMap.get(cart.getProduct().getId());
        if (cart.getQuantity() >= Long.parseLong(discount.getQuantity())) {
          if (discount.getDiscountCatagory().equals("percent")) {
            ans += cart.getQuantity() * cart.getProduct().getPrice() - (cart.getQuantity() * cart.
                getProduct().getPrice()
                * Long.parseLong(hashMap.get(cart.getProduct().getId()).getAmount()) / 100);
          }
        }
      }
    }

    return ans;
  }
}
