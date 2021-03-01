package com.example.capitalfloat.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "discount")
public class Discount {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "discount_catagry", nullable = false)
  private String discountCatagory;

  @Column(name = "is_expire")
  private boolean isExpired;


  @Column(name = "amount", nullable = false)
  private String amount;

  @Column(name = "quantity", nullable = false)
  private String quantity;

  @ManyToOne
  @JoinColumn(name = "product_id", nullable = false)
  private Product product;

}
