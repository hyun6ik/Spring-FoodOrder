package com.example.foodorder.web.controller.menu;

import com.example.foodorder.domain.entity.Menu;
import com.example.foodorder.domain.service.menu.MenuService;
import com.example.foodorder.utils.validation.ValidationUtils;
import com.example.foodorder.web.dto.request.menu.MenuCreateRequest;
import com.example.foodorder.web.dto.response.menu.MenuCreateResponse;
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
@RequiredArgsConstructor
@Slf4j
@RequestMapping("menu/api")
public class MenuApiController {

    private final MenuService menuService;

    @PostMapping("create")
    public ResponseEntity<MenuCreateResponse> createMenu(@Valid @RequestBody MenuCreateRequest request, BindingResult bindingResult) throws BindException {
        ValidationUtils.validateBindingResult(bindingResult);
        return ResponseEntity.ok(MenuCreateResponse.of(menuService.createMenu(request)));
    }
}
