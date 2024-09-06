package com.ohgiraffers.springboot.menu.controller;

import com.ohgiraffers.springboot.menu.model.dto.CategoryDTO;
import com.ohgiraffers.springboot.menu.model.dto.MenuDTO;
import com.ohgiraffers.springboot.menu.model.service.Regist;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/menu")
public class MenuController {

    private static final Logger logger = LogManager.getLogger(MenuController.class);

    private final Regist menuService;
    private final MessageSource messageSource;

    @Autowired
    public MenuController(Regist menuService, MessageSource messageSource) {
        this.menuService = menuService;
        this.messageSource = messageSource;
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

}
