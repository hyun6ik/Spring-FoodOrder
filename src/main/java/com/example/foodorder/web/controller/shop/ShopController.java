package com.example.foodorder.web.controller.shop;

import com.example.foodorder.domain.entity.Shop;
import com.example.foodorder.domain.service.shop.ShopService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("shop")
public class ShopController {

    private final ShopService shopService;

    @GetMapping("list")
    public String shopList(Model model) {
        final List<Shop> shopList = shopService.retrieveShopList();
        model.addAttribute("shopList", shopList);
        return "shop/list";
    }
}
