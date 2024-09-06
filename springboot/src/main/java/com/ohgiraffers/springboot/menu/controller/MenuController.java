package com.ohgiraffers.springboot.menu.controller;

import com.ohgiraffers.springboot.menu.model.dto.CategoryDTO;
import com.ohgiraffers.springboot.menu.model.dto.MenuDTO;
import com.ohgiraffers.springboot.menu.model.service.MenuService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/menu")
public class MenuController {

    private static final Logger logger = LogManager.getLogger(MenuController.class);

    private final MenuService menuService;
    private final MessageSource messageSource;

    @Autowired
    public MenuController(MenuService menuService, MessageSource messageSource) {
        this.menuService = menuService;
        this.messageSource = messageSource;
    }

    @PostMapping("/delete/{code}")
    public String deleteMenu(@PathVariable("code") int code, RedirectAttributes redirectAttributes) {

        menuService.deleteMenu(code);
        redirectAttributes.addFlashAttribute("successMessage", "삭제 완료");
        return "redirect:/menu/list";
    }
    @GetMapping("regist")
    public void registPage() {}

    @GetMapping(value = "category", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<CategoryDTO> findCategoryList() {
        System.out.println("JavaScript 내장 함수 fetch...아직 이해가 잘 안 되었읍니다.");
        return menuService.findAllCategory();
    }

    @PostMapping("regist")
    public String registMenu(MenuDTO newMenu, RedirectAttributes rAttr, Locale locale) {

        menuService.registNewMenu(newMenu);

        logger.info("Locale : {}", locale);

        rAttr.addFlashAttribute("successMessage", messageSource.getMessage("registMenu", null, locale));

        return "redirect:/menu/list";
    }


    @GetMapping("/list")
    public String findMenuList(Model model) {

        List<MenuDTO> menuList = menuService.findAllMenu();

        model.addAttribute("menuList", menuList);
        System.out.println("잘찍히나요?");
        return "menu/list";
    }


    @GetMapping("/detail/{code}")
    public String selectOne(@PathVariable(value = "code") int code, RedirectAttributes redirectAttributes) {
        MenuDTO menu =  menuService.selectOne(code);

        System.out.println(menu);
        //null 일 때 처리 -> detail화면으로 가서 하기
        if(menu!= null)
            redirectAttributes.addFlashAttribute("result", menu);
        System.out.println("리다이렉트 보냄");
        return "redirect:/menu/detail";
    }

    @GetMapping("/detail")
    public void detail() {
        System.out.println("리다이렉트가 안닿음");
    }
}
