package com.example.foodorder.web.dto.response.menu;

import com.example.foodorder.domain.entity.Menu;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MenuCreateResponse {

    private Long shopId;
    private String foodName;

    public MenuCreateResponse(Long shopId, String foodName) {
        this.shopId = shopId;
        this.foodName = foodName;
    }

    public static MenuCreateResponse of(Menu menu) {
        return new MenuCreateResponse(menu.getShopId(), menu.getFoodName());
    }
}
