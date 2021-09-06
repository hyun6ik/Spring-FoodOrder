package com.example.foodorder.domain.service.menu;

import com.example.foodorder.domain.entity.Menu;
import com.example.foodorder.domain.repository.menu.MenuRepository;
import com.example.foodorder.web.dto.request.menu.MenuCreateRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@Slf4j
@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService {

    private final MenuRepository menuRepository;

    @Transactional
    @Override
    public Menu createMenu(MenuCreateRequest request) {
        return menuRepository.save(Menu.of(request.getShopId(), request.getFoodName()));
    }

    @Override
    public List<Menu> retrieveMenuList(Long shopId) {
        return menuRepository.findAllByShopId(shopId);
    }
}
