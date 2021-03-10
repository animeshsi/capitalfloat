package com.example.capitalfloat.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import com.example.capitalfloat.entity.Cart;
import com.example.capitalfloat.entity.Discount;
import com.example.capitalfloat.mapper.DiscountDtoToDiscountMapper;
import com.example.capitalfloat.mapper.DiscountToDiscountDtoMapper;
import com.example.capitalfloat.model.CartDto;
import com.example.capitalfloat.model.DiscountDto;
import com.example.capitalfloat.model.Order;
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
  public DiscountDto addDiscount(DiscountDto discountDto) {
    Discount discount = new DiscountDtoToDiscountMapper().apply(discountDto);
    return new DiscountToDiscountDtoMapper().apply(discountRepository.save(discount));

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
          } else {
            ans += cart.getQuantity() * cart.getProduct().getPrice() -
                Long.parseLong(hashMap.get(cart.getProduct().getId()).getAmount());
          }
        }
      }
    }

    return ans;
  }

  @Override
  public Order getOrderList(Long userId) {
    List<Cart> list = cartRepository.findByUserId(userId);
    Double ans = 0.0;
    List<Long> productIds = list.stream().map(cart -> cart.getProduct().getId()).
        collect(Collectors.toList());
    List<Discount> discountList = discountRepository.findByProductIdIn(productIds);
    Map<Object, Discount> hashMap = discountList.stream().collect(Collectors.toMap
        (discount -> discount.getProduct().getId(), discount -> discount));
    List<CartDto> list1=new ArrayList<>();
    for (Cart cart : list) {

      if (hashMap.containsKey(cart.getProduct().getId())) {
        Discount discount = hashMap.get(cart.getProduct().getId());
        if (cart.getQuantity() >= Long.parseLong(discount.getQuantity())) {
          if (discount.getDiscountCatagory().equals("percent")) {
            list1.add(CartDto.builder().productName(cart.getProduct().getProductName()).originalPrice
                (cart.getQuantity() * cart.getProduct().getPrice()).discount(cart.getQuantity()
                * cart.getProduct().getPrice() * Long.parseLong(hashMap.get(cart.getProduct().
                getId()).getAmount()) / 100).afterDiscount(cart.getQuantity() * cart.getProduct()
                .getPrice() - (cart.getQuantity() * cart.getProduct().getPrice() * Long.parseLong
                (hashMap.get(cart.getProduct().getId()).getAmount()) / 100))
                .quantity(cart.getQuantity()).build());
            ans += cart.getQuantity() * cart.getProduct().getPrice() - (cart.getQuantity() * cart.
                getProduct().getPrice()
                * Long.parseLong(hashMap.get(cart.getProduct().getId()).getAmount()) / 100);
          } else if(discount.getDiscountCatagory().equals("onproduct")) {
          list1.add( CartDto.builder().quantity(cart.getQuantity()+Long.parseLong(hashMap.get(cart.getProduct(
           ).getId()).getAmount())).discount(0d).originalPrice(cart.getQuantity() * cart.getProduct(
           ).getPrice()).afterDiscount(cart.getQuantity() * cart.getProduct().getPrice()).
               productName(cart.getProduct().getProductName()).build());
          }
        }
        else
        {
          list1.add( CartDto.builder().quantity(cart.getQuantity()).discount(0d).originalPrice(cart.getQuantity() * cart.getProduct(
          ).getPrice()).afterDiscount(cart.getQuantity() * cart.getProduct().getPrice()).
              productName(cart.getProduct().getProductName()).build());
          ans+=cart.getQuantity() * cart.getProduct(
          ).getPrice();
        }
      }

    }
    return Order.builder().cartList(list1).userId(userId).totalamount(ans).build();
  }


}
