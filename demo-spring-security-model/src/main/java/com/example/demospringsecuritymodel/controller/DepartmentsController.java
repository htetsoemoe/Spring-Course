package com.example.demospringsecuritymodel.controller;

import com.example.demospringsecuritymodel.dao.DepartmentsDao;
import com.example.demospringsecuritymodel.entities.Department;
import com.example.demospringsecuritymodel.security.annotations.departments.IsDepartmentsCreate;
import com.example.demospringsecuritymodel.security.annotations.departments.IsDepartmentsDelete;
import com.example.demospringsecuritymodel.security.annotations.departments.IsDepartmentsRead;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class DepartmentsController {

    @Autowired
    private DepartmentsDao departmentsDao;

    @IsDepartmentsRead
    @GetMapping("/departments")
    public ModelAndView index() {
        return new ModelAndView("departments", "departments", departmentsDao.findAll());
    }

    @IsDepartmentsCreate
    @GetMapping("/departments/create")
    public ModelAndView create() {
        return new ModelAndView("department-create", "department", new Department());
    }

    @IsDepartmentsCreate
    @PostMapping("/departments/create")
    public String create(@ModelAttribute @Valid Department department, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "department-create";
        } else {
            departmentsDao.save(department);
        }

        return "redirect:/departments";
    }

    @IsDepartmentsDelete
    @GetMapping("/departments/delete/{id}")
    public String delete(@PathVariable Integer id) {
        departmentsDao.deleteById(id);
        return "redirect:/departments";
    }
}
