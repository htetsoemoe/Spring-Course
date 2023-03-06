package com.example.demotodo.web;

import com.example.demotodo.dao.TodoItemsDao;
import com.example.demotodo.ds.TodoItems;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class TodoController {
    @Autowired
    private TodoItemsDao todoItemsDao;

    @GetMapping("/")
    public String index(TodoItems todoItems, Model model) {
        model.addAttribute("todoItems", todoItemsDao.findAll());
        model.addAttribute("todoItem", todoItems);
        return "index"; // redirect index page
    }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute TodoItems todoItems, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return index(todoItems, model);
        } else {
            todoItemsDao.save(todoItems);
            return "redirect:/";
        }
    }
}
