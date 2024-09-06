package com.ohgiraffers.springboot.menu.model.service;

import com.ohgiraffers.springboot.menu.model.dao.MenuMapper;
import com.ohgiraffers.springboot.menu.model.dto.MenuDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SelectOne {
    private final MenuMapper menuMapper;

    @Autowired
    public SelectOne(MenuMapper menuMapper) {
        this.menuMapper = menuMapper;
    }

    public MenuDTO selectOne(int code) {
        System.out.println("서비스단 쿼리문 확인"+menuMapper.findMenuByCode(code));
        return menuMapper.findMenuByCode(code);
    }
}
