package com.example.foodorder.domain.service.order;

import com.example.foodorder.domain.entity.Orders;
import com.example.foodorder.web.dto.request.menu.MenuForm;

public interface OrderService {
    Orders createOrder(MenuForm form);
}
