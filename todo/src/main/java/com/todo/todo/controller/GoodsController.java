package com.todo.todo.controller;

import com.todo.todo.entity.Goods;
import com.todo.todo.service.GoodsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/goods")
@RequiredArgsConstructor
public class GoodsController {

    private final GoodsService goodsService;

    // 조회 뷰
    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("goods", goodsService.list());
        return "list";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Long id, Model model) {
        model.addAttribute("goods", goodsService.detail(id));
        return "detail";
    }

    // 등록 뷰
    @GetMapping("/register")
    public String registerGet() {
        return "insert";
    }

    // 등록 후 페이지 이동
    @PostMapping("/register")
    public String registerPost(Goods goods) {
        goodsService.register(goods);
        return "redirect:/goods/list";
    }

    // 상세(삭제) 뷰
    @GetMapping("/delete/{id}")
    public String deletePost(@PathVariable Long id) {
        goodsService.delete(id);
        return "redirect:/goods/list";
    }

    @GetMapping("/update/{id}")
    public String updateGet(@PathVariable Long id, Model model) {
        model.addAttribute("goods", goodsService.detail(id));
        return "update";
    }

    @PostMapping("/update")
    public String updatePost(Goods changeGoods) {
        goodsService.update(changeGoods);
        return "redirect:/goods/list";
    }
}
