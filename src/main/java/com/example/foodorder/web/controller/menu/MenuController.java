package com.example.foodorder.web.controller.menu;

import com.example.foodorder.domain.entity.Menu;
import com.example.foodorder.domain.service.menu.MenuService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        return "menu/list";
    }
}
