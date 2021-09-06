package com.example.foodorder.web.controller.order;

import com.example.foodorder.domain.service.order.OrderService;
import com.example.foodorder.web.dto.request.shop.ShopCreateRequest;
import com.example.foodorder.web.dto.response.shop.ShopCreateResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Controller
@Slf4j
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

}
