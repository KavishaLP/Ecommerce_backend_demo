package com.kelaniya.uni.e_commerce_system.data_access;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class OrderEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Long id;

  public String orderNumber;
  public String customerNumber;

  //public List<OrderLineItemEntity> lineItems = new ArrayList<>();

}

//ORM: Object-Relational Mapping