package com.ohgiraffers.springboot.menu.controller;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/menu")
public class MenuController {

    private static final Logger logger = LogManager.getLogger(MenuController.class);
    private final MenuService menuService;
    private final MessageSource messageSource;

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
}
