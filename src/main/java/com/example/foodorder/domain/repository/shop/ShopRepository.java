package com.example.foodorder.domain.repository.shop;

import com.example.foodorder.domain.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepository extends JpaRepository<Shop, Long> {
}
