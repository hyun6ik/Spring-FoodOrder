package com.example.foodorder.domain.repository.shop;

import com.example.foodorder.domain.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShopRepository extends JpaRepository<Shop, Long> {

    Optional<Shop> findById(Long id);
}
