package com.example.foodorder.web.controller.order;

import com.example.foodorder.domain.service.order.OrderService;
import com.example.foodorder.utils.validation.ValidationUtils;
import com.example.foodorder.web.dto.request.shop.ShopCreateRequest;
import com.example.foodorder.web.dto.response.shop.ShopCreateResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("order/api")
public class OrderApiController {

    private final OrderService orderService;


}
