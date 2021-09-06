package com.example.foodorder.web.dto.request.shop;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ShopCreateRequest {

    private String shopName;
    private String shopAddress;
}
