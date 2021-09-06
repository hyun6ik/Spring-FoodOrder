package com.example.foodorder.domain.service.menu;

import com.example.foodorder.domain.entity.Menu;
import com.example.foodorder.web.dto.request.menu.MenuCreateRequest;

import java.util.List;

public interface MenuService {
    Menu createMenu(MenuCreateRequest request);

    List<Menu> retrieveMenuList(Long shopId);
}
