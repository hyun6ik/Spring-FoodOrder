package com.example.foodorder.domain.repository.order;

import com.example.foodorder.domain.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Orders, Long> {
    List<Orders> findByShopId(Long shopId);
}
