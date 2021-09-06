package com.example.foodorder.web.controller.shop;

import com.example.foodorder.domain.entity.Shop;
import com.example.foodorder.domain.service.shop.ShopService;
import com.example.foodorder.utils.validation.ValidationUtils;
import com.example.foodorder.web.dto.request.shop.ShopCreateRequest;
import com.example.foodorder.web.dto.response.shop.ShopCreateResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("shop/api")
public class ShopApiController {

    private final ShopService shopService;

    @PostMapping("create")
    public ResponseEntity<ShopCreateResponse> createShop(@Valid @RequestBody ShopCreateRequest request, BindingResult bindingResult) throws BindException {
        ValidationUtils.validateBindingResult(bindingResult);
        return ResponseEntity.ok(ShopCreateResponse.of(shopService.createShop(request)));
    }
}
