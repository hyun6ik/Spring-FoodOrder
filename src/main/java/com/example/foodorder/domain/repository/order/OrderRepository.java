package com.example.foodorder.domain.repository.order;

import com.example.foodorder.domain.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders, Long> {
}
