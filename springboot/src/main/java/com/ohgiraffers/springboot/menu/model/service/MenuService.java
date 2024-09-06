package com.ohgiraffers.springboot.menu.model.service;


import com.ohgiraffers.springboot.menu.model.dao.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
<<<<<<< HEAD

import java.util.List;
=======
>>>>>>> 379a3c69af8c356d387b20be01d5923bec34e5ca

@Service
public class MenuService {
    private final MenuMapper menuMapper;

    @Autowired
    public MenuService(MenuMapper menuMapper) {
        this.menuMapper = menuMapper;}

<<<<<<< HEAD
    public MenuDTO findMenuByCode(int code) {
        return menuMapper.findMenuByCode(code);
    }

    @Transactional
    public void updateMenu(MenuDTO menu) {
        menuMapper.updateMenu(menu);
    }
=======
    @Transactional
    public void deleteMenu(int code) {menuMapper.deleteMenu(code);}
>>>>>>> 379a3c69af8c356d387b20be01d5923bec34e5ca
}
