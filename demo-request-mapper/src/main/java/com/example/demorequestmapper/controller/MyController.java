package com.example.demorequestmapper.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//@RequestMapping("/helloWorld")
public class MyController {
    //http://localhost:8080/helloWorld
    @GetMapping("/")
    //@RequestMapping(value = "/", method = RequestMethod.GET)
    public String helloWorld(Model model) {
        model.addAttribute("msg", "Welcome Java Spring Class");
        return "mypage1";
    }

    @GetMapping("/sayspring")
    public String saySpring(Model model) {
        model.addAttribute("msg", "Saying Spring");
        return "mypage1";
    }

    @GetMapping("/welcome")
    public String saySpringMVC(Model model) {
        model.addAttribute("taglig", "Spring MVC");
        return "welcome";
    }

    @GetMapping("/welcome/hobby")
    public String showHobby(Model model) {
        model.addAttribute("taglig", "Reading");
        return "welcome";
    }

}
