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
        this.menuMapper = menuMapper;}

    public MenuDTO findMenuByCode(int code) {
        return menuMapper.findMenuByCode(code);
    }

    @Transactional
    public void updateMenu(MenuDTO menu) {
        menuMapper.updateMenu(menu);
    }
    @Transactional
    public void deleteMenu(int code) {menuMapper.deleteMenu(code);}

    public List<MenuDTO> findAllMenu() {
        return menuMapper.findAllMenu();
    }

    public List<CategoryDTO> findAllCategory() {
        return menuMapper.findAllCategory();
    }

    @Transactional
    public void registNewMenu(MenuDTO newMenu) {

        menuMapper.registNewMenu(newMenu);

    }

    public MenuDTO selectOne(int code) {
        System.out.println("서비스단 쿼리문 확인"+menuMapper.findMenuByCode(code));
        return menuMapper.findMenuByCode(code);
    }
}


