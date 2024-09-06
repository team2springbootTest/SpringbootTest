package com.ohgiraffers.springboot.menu.controller;

import com.ohgiraffers.springboot.menu.model.dto.MenuDTO;
import com.ohgiraffers.springboot.menu.model.service.SelectOne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SelectOneController {
    private final SelectOne service;

    @Autowired
    public SelectOneController(SelectOne service) {
        this.service = service;
    }

    @GetMapping("/menu/detail/{code}")
    public String selectOne(@PathVariable(value = "code") int code, RedirectAttributes redirectAttributes) {
        MenuDTO menu =  service.selectOne(code);

        System.out.println(menu);
        //null 일 때 처리 -> detail화면으로 가서 하기
        if(menu!= null)
            redirectAttributes.addFlashAttribute("result", menu);
        return "redirect:/menu/detail";
    }

    @GetMapping("/menu/detail")
    public void detail() {
    }
}
