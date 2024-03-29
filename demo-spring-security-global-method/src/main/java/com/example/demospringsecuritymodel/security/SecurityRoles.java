package com.example.demospringsecuritymodel.security;

public interface SecurityRoles {

    String ROLE_PREFIX = "ROLE_";// public static final

    String SUPER_ADMIN = "SUPER_ADMIN";

    String CUSTOMERS_ADMIN = "CUSTOMERS_ADMIN";
    String CUSTOMERS_READ = "CUSTOMERS_READ";
    String CUSTOMERS_CREATE = "CUSTOMERS_CREATE";
    String CUSTOMERS_DELETE = "CUSTOMERS_DELETE";
    String CUSTOMERS_PAGE_VIEW = "CUSTOMERS_PAGE_VIEW";

    String DEPARTMENTS_ADMIN = "DEPARTMENTS_ADMIN";
    String DEPARTMENTS_READ = "DEPARTMENTS_READ";
    String DEPARTMENTS_CREATE = "DEPARTMENTS_CREATE";
    String DEPARTMENTS_DELETE = "DEPARTMENTS_DELETE";
    String DEPARTMENTS_PAGE_VIEW = "DEPARTMENTS_PAGE_VIEW";

    String EMPLOYEES_ADMIN = "EMPLOYEES_ADMIN";
    String EMPLOYEES_READ = "EMPLOYEES_READ";
    String EMPLOYEES_CREATE = "EMPLOYEES_CREATE";
    String EMPLOYEES_DELETE = "EMPLOYEES_DELETE";
    String EMPLOYEES_PAGE_VIEW = "EMPLOYEES_PAGE_VIEW";

    // these lines added while studying ** pattern, 17.1.22 Mon Day 55 Spring Security Day 9

    String ALL_VIEW = "ALL_VIEWS";
    String ALL_CREATE = "ALL_CREATES";
    String ALL_DELETE = "ALL_DELETE";


}
