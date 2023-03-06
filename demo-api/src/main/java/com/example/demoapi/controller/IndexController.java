package com.example.demoapi.controller;

import com.example.demoapi.dao.ArticleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @Autowired
    private ArticleDao articleDao;

    @GetMapping({"/", "/index", "/home"})
    public String index(Model model) {
        model.addAttribute("articles", articleDao.findAll());
        return "index";
    }
}
