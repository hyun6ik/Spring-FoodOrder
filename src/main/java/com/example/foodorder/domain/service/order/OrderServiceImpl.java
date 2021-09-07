package com.example.foodorder.domain.service.order;

import com.example.foodorder.domain.entity.OrderFood;
import com.example.foodorder.domain.entity.Orders;
import com.example.foodorder.domain.repository.order.OrderRepository;
import com.example.foodorder.web.dto.request.menu.MenuForm;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Transactional
    @Override
    public Orders createOrder(MenuForm form) {
        final Orders order = Orders.of(form.getAddress(), LocalDateTime.now(), form.getShopId());
        for (String foodName : form.getFoodList()) {
            order.addOrderFood(OrderFood.of(foodName));
        }
        return orderRepository.save(order);
    }

    @Override
    public List<Orders> findByShopId(Long shopId) throws NotFoundException {
        return orderRepository.findByShopId(shopId);
    }

    @Transactional
    @Override
    public Orders save(Orders order) {
        return orderRepository.save(order);
    }

    @Override
    public Orders findById(Long orderId) throws NotFoundException {
        return orderRepository.findById(orderId).orElseThrow(() -> new NotFoundException("없어요!"));
    }

    @Transactional
    @Override
    public Orders changeEstTime(Orders orders, int estimatedTime) {
        orders.changeEstTime(estimatedTime);
        return orderRepository.save(orders);
    }

}
