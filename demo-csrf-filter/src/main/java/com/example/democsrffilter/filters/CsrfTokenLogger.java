package com.example.democsrffilter.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.csrf.CsrfToken;

import javax.servlet.*;
import java.io.IOException;

public class CsrfTokenLogger implements Filter {

    private Logger logger = LoggerFactory.getLogger(CsrfTokenLogger.class.getName());

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        Object object = servletRequest.getAttribute("_csrf");
        CsrfToken token = (CsrfToken) object;
        logger.info("CSRF Token " + token.getToken());

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
