package com.example.demosecuritysalt.controller;

import com.example.demosecuritysalt.ds.RegisteringUser;
import com.example.demosecuritysalt.validation.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Collections;

@Controller
public class AccountController {
    @Autowired
    private UserDetailsManager userDetailsManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/account")
    public String account() {
        return "account";
    }

    @GetMapping("/register")
    public ModelAndView register() {
        return new ModelAndView("register", "user", new RegisteringUser());
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("user") @Valid RegisteringUser user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // BindingResult :  Particular example: use a BindingResult object as an argument for a validate method of a Validator inside a Controller.  Then, you can check this object looking for validation errors:
            return "register";
        } else {
            userDetailsManager.createUser(
                    new User(
                            user.getUsername(),
                            passwordEncoder.encode(user.getPassword()),
                            Collections.singletonList(new SimpleGrantedAuthority("USERS"))
                    )
            );
        }
        return "redirect:/login";
    }

    @InitBinder
    public void initBinder(DataBinder binder) {
        binder.addValidators(new UserValidator());
    }
}
