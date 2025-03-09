package com.kelaniya.uni.e_commerce_system;

import java.util.ArrayList;
import java.util.List;

public class OrderResponse {

  //todo: use getters and setters
  public String orderNumber;
  public String customerNumber;

  public List<OrderLineItem> lineItems = new ArrayList<>();

}
