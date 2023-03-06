package com.example.demospringsecuritymodel.security.filter;

import com.example.demospringsecuritymodel.security.SecurityRoles;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.util.Collections;

// http://localhost:8080/employees?X_AUTH_TOKEN=SECRETE_AUTH_TOKEN_ADMIN

public class CustomRequestParameterAuthenticationFilter extends GenericFilterBean {

    public static final String SECRETE_AUTH_TOKEN_ADMIN = "SECRETE_AUTH_TOKEN_ADMIN";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        SecurityContext securityContext = SecurityContextHolder.getContext();

        if (SECRETE_AUTH_TOKEN_ADMIN.equals(request.getParameter("X_AUTH_TOKEN")) && securityContext != null) {
           securityContext.setAuthentication(
                   new AnonymousAuthenticationToken(
                           "x_auth", "X_ADMIN",
                           Collections.singletonList(
                                   new SimpleGrantedAuthority(SecurityRoles.ROLE_PREFIX + SecurityRoles.SUPER_ADMIN)
                           )
                   )
           );
        }

        chain.doFilter(request, response);
    }
}
