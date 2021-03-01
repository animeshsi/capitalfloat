package com.example.capitalfloat.model;

import javax.persistence.Column;
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
public class ProductDto {
  private Long id;

  private String productName;

  private Long quantity;

  private Double price;

  private String category;
}
