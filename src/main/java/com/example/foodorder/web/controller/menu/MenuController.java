package com.example.foodorder.web.controller.menu;

import com.example.foodorder.domain.entity.Menu;
import com.example.foodorder.domain.entity.Orders;
import com.example.foodorder.domain.service.menu.MenuService;
import com.example.foodorder.domain.service.shop.ShopService;
import com.example.foodorder.web.dto.request.menu.MenuForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("menu")
public class MenuController {

    private final MenuService menuService;

    @GetMapping("list")
    public String list(@RequestParam Long shopId, Model model) {
        final List<Menu> menuList = menuService.retrieveMenuList(shopId);

        model.addAttribute("menuList", menuList);
        model.addAttribute("form", new MenuForm());
        model.addAttribute("shopId", shopId);
        return "menu/list";
    }


}
