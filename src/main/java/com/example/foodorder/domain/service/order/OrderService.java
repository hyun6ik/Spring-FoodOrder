package com.example.foodorder.domain.service.order;

import com.example.foodorder.domain.entity.Orders;
import com.example.foodorder.web.dto.request.menu.MenuForm;
import javassist.NotFoundException;
import org.aspectj.weaver.ast.Or;
import org.springframework.ui.Model;

import java.util.List;

public interface OrderService {
    Orders createOrder(MenuForm form);

    List<Orders> findByShopId(Long shopId) throws NotFoundException;


    Orders save(Orders order);

    Orders findById(Long orderId) throws NotFoundException;

    Orders changeEstTime(Orders orders, int estimatedTime);

    Long deliveryUpdate(Long orderId) throws NotFoundException;
}
