package com.example.capitalfloat.model;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.example.capitalfloat.entity.Product;
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
public class DiscountDto {
  private Long id;

  private String discountCatagory;

  private boolean isExpired;

  private String amount;

  private String quantity;

  private Product product;
}
