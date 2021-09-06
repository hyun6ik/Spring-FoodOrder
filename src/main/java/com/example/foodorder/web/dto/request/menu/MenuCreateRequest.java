package com.example.foodorder.web.dto.request.menu;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MenuCreateRequest {

    private Long shopId;
    private String foodName;
}
