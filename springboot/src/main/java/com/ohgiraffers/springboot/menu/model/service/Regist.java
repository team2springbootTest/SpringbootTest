package com.ohgiraffers.springboot.menu.model.service;

import com.ohgiraffers.springboot.menu.model.dao.MenuMapper;
import com.ohgiraffers.springboot.menu.model.dto.CategoryDTO;
import com.ohgiraffers.springboot.menu.model.dto.MenuDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class Regist {

    private final MenuMapper menuMapper;

    @Autowired
    public Regist(MenuMapper menuMapper) {
        this.menuMapper = menuMapper;
    }

    public List<CategoryDTO> findAllCategory() {

        return menuMapper.findAllCategory();
    }

    @Transactional
    public void registNewMenu(MenuDTO newMenu) {

        menuMapper.registNewMenu(newMenu);

    }
}
