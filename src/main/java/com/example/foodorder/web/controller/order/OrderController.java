package com.example.foodorder.web.controller.order;

import com.example.foodorder.domain.entity.OrderFood;
import com.example.foodorder.domain.entity.Orders;
import com.example.foodorder.domain.entity.Shop;
import com.example.foodorder.domain.service.order.OrderService;
import com.example.foodorder.domain.service.shop.ShopService;
import com.example.foodorder.web.dto.request.menu.MenuForm;
import com.example.foodorder.web.dto.request.order.EstTimeForm;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
        final Orders order = orderService.createOrder(form);
        final List<String> foodList = order.getFoodList().stream().map(OrderFood::getFoodName).collect(Collectors.toList());
        final Shop shop = shopService.findShopById(order.getShopId());

        model.addAttribute("order", order);
        model.addAttribute("shopName", shop.getShopName());
        model.addAttribute("foodList", foodList);
        return "order/createOrder";
    }

    @GetMapping("timeInput")
    public String timeInput(@RequestParam Long shopId, Model model) throws NotFoundException {
        final List<Orders> orderList = orderService.findByShopId(shopId);

        model.addAttribute("orderList", orderList);
        model.addAttribute("form", new EstTimeForm());
        return "boss/timeInput";
    }


    @PostMapping("timeInputSave")
    public String saveEstTime(@RequestParam Long orderId, @ModelAttribute EstTimeForm form, RedirectAttributes redirectAttributes) throws NotFoundException {
        final Orders order = orderService.changeEstTime(orderService.findById(orderId), form.getEstimatedTime());

        redirectAttributes.addAttribute("shopId", order.getShopId());
        return "redirect:/order/timeInput";
    }

    @GetMapping("deliveryList")
    public String deliveryList(@RequestParam Long shopId, Model model) throws NotFoundException {
        final List<Orders> ordersList = orderService.findByShopId(shopId);

        model.addAttribute("orderList", ordersList);
        return "delivery/deliveryInput";
    }

    @GetMapping("deliveryUpdate")
    public String deliveryUpdate(@RequestParam Long orderId, RedirectAttributes redirectAttributes) throws NotFoundException {
        final Long shopId = orderService.deliveryUpdate(orderId);

        redirectAttributes.addAttribute("shopId", shopId);
        return "redirect:/order/deliveryList";
    }



}
