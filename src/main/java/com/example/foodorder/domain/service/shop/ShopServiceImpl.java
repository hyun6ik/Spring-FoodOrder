package com.example.foodorder.domain.service.shop;

import com.example.foodorder.domain.entity.Shop;
import com.example.foodorder.domain.repository.shop.ShopRepository;
import com.example.foodorder.web.dto.request.shop.ShopCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ShopServiceImpl implements ShopService {

    private final ShopRepository shopRepository;


    @Override
    public Shop createShop(ShopCreateRequest request) {
        return shopRepository.save(Shop.of(request.getShopName(), request.getShopAddress()));
    }
}
