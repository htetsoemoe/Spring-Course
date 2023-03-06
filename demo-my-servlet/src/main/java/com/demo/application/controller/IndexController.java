package com.demo.application.controller;

import com.demo.application.view.IndexView;
import com.demo.framework.controller.ControllerMapping;
import com.demo.framework.controller.IController;
import com.demo.framework.ds.ModelAndView;
import com.demo.framework.model.SampleModel;

import javax.servlet.http.HttpServletRequest;

@ControllerMapping("/")
public class IndexController implements IController {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request) {
        return new ModelAndView(
                new SampleModel(),
                new IndexView()
        );
    }
}
