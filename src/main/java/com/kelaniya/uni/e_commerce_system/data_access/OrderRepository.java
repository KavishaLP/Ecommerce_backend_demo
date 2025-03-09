package com.kelaniya.uni.e_commerce_system.data_access;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface OrderRepository extends CrudRepository<OrderEntity, Long> {

  Optional<OrderEntity> findByOrderNumber(String orderNumber);
}
