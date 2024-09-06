package com.ohgiraffers.springboot.menu.model.dao;

import com.ohgiraffers.springboot.menu.model.dto.CategoryDTO;
import com.ohgiraffers.springboot.menu.model.dto.MenuDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuMapper {

    List<MenuDTO> findAllMenu();

    List<CategoryDTO> findAllCategory();

    void registNewMenu(MenuDTO newMenu);

    MenuDTO findMenuByCode(int code);

    void updateMenu(MenuDTO menu);

    void deleteMenu(int code);
}
