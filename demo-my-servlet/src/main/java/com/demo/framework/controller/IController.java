package com.demo.framework.controller;

import com.demo.framework.ds.ModelAndView;

import javax.servlet.http.HttpServletRequest;

public interface IController {
    ModelAndView handleRequest(HttpServletRequest request);
}
