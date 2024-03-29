package com.example.demospringsecuritymodel.controller;

import com.example.demospringsecuritymodel.dao.EmployeesDao;
import com.example.demospringsecuritymodel.entities.Employee;
import com.example.demospringsecuritymodel.security.annotations.employees.IsEmployeesCreate;
import com.example.demospringsecuritymodel.security.annotations.employees.IsEmployeesDelete;
import com.example.demospringsecuritymodel.security.annotations.employees.IsEmployeesRead;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class EmployeesController {

    @Autowired
    private EmployeesDao employeesDao;

    //@IsEmployeesRead

    @PreAuthorize("hasRole('ROLE_EMPLOYEES_READ')")
    @GetMapping("/employees")
    public ModelAndView index() {
        return new ModelAndView("employees", "employees", employeesDao.findAll());
    }

    // command object or form object
    //@IsEmployeesCreate

    @PreAuthorize("hasRole('ROLE_EMPLOYEES_READ')")
    @GetMapping("/employees/create")
    public ModelAndView create() {
        return new ModelAndView("employee-create", "employee", new Employee());
    }

    //@IsEmployeesCreate

    @PreAuthorize("'TEST'.equals(#employee.getFirstName()) || hasRole('ROLE_EMPLOYEES_CREATE')")
    @PostMapping("/employees/create")
    public String create(@ModelAttribute @Valid Employee employee, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "employee-create";
        } else {
            employeesDao.save(employee);
        }

        return "redirect:/employees";
    }

    //@IsEmployeesDelete

    @PreAuthorize("#id <= 2 || hasRole('ROLE_EMPLOYEES_DELETE')")
    @GetMapping("/employees/delete/{id}")
    public String delete(@PathVariable Integer id) {
        employeesDao.deleteById(id);
        return "redirect:/employees";
    }
}
