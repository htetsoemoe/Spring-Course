package com.example.demospringsecuritymodel.controller;

import com.example.demospringsecuritymodel.dao.CustomersDao;
import com.example.demospringsecuritymodel.entities.Customer;
import com.example.demospringsecuritymodel.security.annotations.customers.IsCustomersCreate;
import com.example.demospringsecuritymodel.security.annotations.customers.IsCustomersDelete;
import com.example.demospringsecuritymodel.security.annotations.customers.IsCustomersRead;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class CustomersController {

    @Autowired
    private CustomersDao customersDao;
//
//    public String customers(Model model) {
//        model.addAttribute("customers", customersDao.findAll());
//        return "customers";
//    }


    @IsCustomersRead
    @GetMapping("/customers")
    public ModelAndView index() {
        return new ModelAndView("customers","customers",customersDao.findAll());
    }

    // command object or form object
    @IsCustomersCreate
    @GetMapping("/customers/create")
    public ModelAndView create() {
        return new ModelAndView("customer-create", "customer", new Customer());
    }

    @IsCustomersCreate
    @PostMapping("/customers/create")
    public String create(@ModelAttribute @Valid Customer customer, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return "customer-create";
        } else {
            customersDao.save(customer);
        }

        return "redirect:/customers"; // destroy old request
        //return "forward:/customers"; // forward is within the same request
    }

    @IsCustomersDelete
    @GetMapping("/customers/delete/{id}")
    public String delete(@PathVariable Integer id) {
        customersDao.deleteById(id);
        return "redirect:/customers";
    }
}
