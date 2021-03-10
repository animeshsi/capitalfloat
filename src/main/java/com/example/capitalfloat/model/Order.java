package com.example.capitalfloat.model;

import java.util.List;
import com.example.capitalfloat.entity.Cart;
import com.example.capitalfloat.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Order {
  private Long userId;
  private List<CartDto> cartList;
  private Double totalamount;

}
