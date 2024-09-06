package com.ohgiraffers.springboot.menu.model.service;

import com.ohgiraffers.springboot.menu.model.dao.MenuMapper;
import com.ohgiraffers.springboot.menu.model.dto.CategoryDTO;
import com.ohgiraffers.springboot.menu.model.dto.MenuDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MenuService {

    private final MenuMapper menuMapper;

    @Autowired
    public MenuService(MenuMapper menuMapper) {
        this.menuMapper = menuMapper;
    }

    public List<MenuDTO> findAllMenu() {
        return menuMapper.findAllMenu();
    }

    public List<CategoryDTO> findAllCategory() {
        return menuMapper.findAllCategory();
    }

    public MenuDTO findMenuByCode(int code) {
        return menuMapper.findMenuByCode(code);
    }

    @Transactional
    public void updateMenu(MenuDTO menu) {
        menuMapper.updateMenu(menu);
    }
}
