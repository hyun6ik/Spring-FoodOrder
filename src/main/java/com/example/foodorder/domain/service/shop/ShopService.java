package com.example.foodorder.domain.service.shop;

import com.example.foodorder.domain.entity.Shop;
import com.example.foodorder.web.dto.request.shop.ShopCreateRequest;

public interface ShopService {
    Shop createShop(ShopCreateRequest request);
}
