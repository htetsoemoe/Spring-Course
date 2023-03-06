package com.example.demorequestmapping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

    // curl -X GET localhost:8080/actionA
    @GetMapping("/actionA")
    @ResponseBody
    public String actionA() {
        return "Handled with @GetMapping(\"/ActionA\")";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/actionB")
    @ResponseBody
    public String actionB() {
        return "Handled with @RequestMapping(method = RequestMethod.GET, path=\"/actionB\")";
    }

    // curl -X GET localhost:8080/actionC
    // curl -X POST localhost:8080/actionC
    // curl -X PATCH localhost:8080/actionC
    @RequestMapping(path = "/actionC")
    @ResponseBody
    public String action() {
        return "Handled with @RequestMapping(path = \"/actionC\")";
    }

    // curl -X POST localhost:8080/actionD
    // curl -X GET localhost:8080/actionD
    @RequestMapping(path = "/actionD", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String actionD() {
        return "Handled with @RequestMapping(path = \"/actionD\", method={RequestMethod.GET, RequestMethod.POST})";
    }
}
