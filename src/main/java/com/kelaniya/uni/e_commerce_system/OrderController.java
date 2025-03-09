package com.kelaniya.uni.e_commerce_system;

import com.kelaniya.uni.e_commerce_system.data_access.OrderEntity;
import com.kelaniya.uni.e_commerce_system.data_access.OrderRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class OrderController {

  private OrderRepository orderRepository;

  public OrderController(OrderRepository orderRepository) {
    this.orderRepository = orderRepository;
  }

  //constructor injection (dependency injection)

  @GetMapping("/order")
  public OrderResponse getOrder(@RequestParam String orderNumber) {
    Optional<OrderEntity> orderEntityOptional = orderRepository.findByOrderNumber(orderNumber);

    if (orderEntityOptional.isPresent()) {

      OrderEntity orderEntity = orderEntityOptional.get();
      OrderResponse orderResponse = new OrderResponse();
      orderResponse.orderNumber = orderEntity.orderNumber;
      orderResponse.customerNumber = orderEntity.customerNumber;
      return orderResponse;

    }
    else {
      throw new RuntimeException("Order not found");
    }

  }

  @PostMapping("/order")// submit order
  public OrderResponse submitOrder(@RequestBody OrderRequest orderRequest) {

    OrderEntity orderEntity = new OrderEntity();
    orderEntity.customerNumber = orderRequest.customerId;

    //random number generation
    String orderNumber = String.valueOf((int) (Math.random() * 10000));

    //todo: check the uniqueness of the order number

    orderEntity.orderNumber = orderNumber;
    orderRepository.save(orderEntity);

    //create the response and send it back
    OrderResponse orderResponse = new OrderResponse();
    orderResponse.orderNumber = orderNumber;
    orderResponse.customerNumber = orderRequest.customerId;
    orderResponse.lineItems = orderRequest.lineItems;
    return orderResponse;

  }

}
