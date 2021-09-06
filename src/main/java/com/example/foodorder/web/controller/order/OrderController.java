package com.example.foodorder.web.controller.order;

import com.example.foodorder.domain.entity.OrderFood;
import com.example.foodorder.domain.entity.Orders;
import com.example.foodorder.domain.entity.Shop;
import com.example.foodorder.domain.service.order.OrderService;
import com.example.foodorder.domain.service.shop.ShopService;
import com.example.foodorder.web.dto.request.menu.MenuForm;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("order")
public class OrderController {

    private final OrderService orderService;
    private final ShopService shopService;


    @PostMapping("list")
    public String getList(@ModelAttribute MenuForm form, Model model) throws NotFoundException {
        System.out.println("form = " + form);
        final Orders order = orderService.createOrder(form);
        final List<String> foodList = order.getFoodList().stream().map(OrderFood::getFoodName).collect(Collectors.toList());
        final Shop shop = shopService.findShopById(order.getShopId());
        model.addAttribute("order", order);
        model.addAttribute("shopName", shop.getShopName());
        model.addAttribute("foodList", foodList);
        return "order/createOrder";
    }
}
