package com.example.capitalfloat.model;


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
public class CartDto {

  private Long quantity;
  private String productName;
  private Double originalPrice;
  private Double discount;
  private Double afterDiscount;

}
