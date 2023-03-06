package com.example.demospringsecuritymodel.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Controller
public class AccountController {

    private static final String MAIN = "main";
    private static final String CHILD = "child";


    @GetMapping("/account")
    public String account(Model model) throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        model.addAttribute("securityContextHolderStrategy",
                SecurityContextHolder.getContextHolderStrategy().getClass().getSimpleName());

        storeSecurityContextDataInModelInMainThread(model);
        storeSecurityContextDataInModelInChildThread(model);

        return "account";
    }

    private void storeSecurityContextDataInModelInMainThread(Model model) {
        storeSecurityContextDataInModel(MAIN, model);
    }

    private void storeSecurityContextDataInModelInChildThread(Model model) throws InterruptedException {
        Thread thread = new Thread(() -> storeSecurityContextDataInModel(CHILD, model));
        thread.start();
        thread.join();
    }

    private void storeSecurityContextDataInModel(String prefix, Model model) {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();

        User user = (User) Optional.ofNullable(authentication)
                .map(Authentication::getPrincipal) // username
                .orElse(null); // there's no username return null

        model.addAttribute(prefix + "HashCode", Integer.toHexString(securityContext.hashCode()));

        model.addAttribute(
            prefix + "Name",
            Optional.ofNullable(authentication)
                    .map(Authentication::getName)
                    .orElse("N/A")
        );

        model.addAttribute(
                prefix + "Username",
                Optional.ofNullable(user)
                        .map(User::getUsername)
                        .orElse("N/A")
        );

        model.addAttribute(
                prefix + "Authorities",
                Optional.ofNullable(authentication)
                        .map(Authentication::getAuthorities)
                        .orElse(null)
        );
    }
}
