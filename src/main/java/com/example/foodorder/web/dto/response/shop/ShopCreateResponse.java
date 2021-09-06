package com.example.foodorder.web.dto.response.shop;

import com.example.foodorder.domain.entity.Shop;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ShopCreateResponse {

    private String shopName;
    private String shopAddress;

    public ShopCreateResponse(String shopName, String shopAddress) {
        this.shopName = shopName;
        this.shopAddress = shopAddress;
    }

    public static ShopCreateResponse of(Shop shop) {
        return new ShopCreateResponse(shop.getShopName(), shop.getShopAddress());
    }
}
