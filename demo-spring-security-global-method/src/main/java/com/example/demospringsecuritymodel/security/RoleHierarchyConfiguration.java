package com.example.demospringsecuritymodel.security;

import com.example.demospringsecuritymodel.security.util.RolesHierarchyBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;

import static com.example.demospringsecuritymodel.security.SecurityRoles.*;

@Configuration
public class RoleHierarchyConfiguration {

    @Bean
    public RoleHierarchy roleHierarchy() {
        RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();

        roleHierarchy.setHierarchy(
                new RolesHierarchyBuilder()
                        .append(SUPER_ADMIN, CUSTOMERS_ADMIN)
                        .append(CUSTOMERS_ADMIN, CUSTOMERS_CREATE)
                        .append(CUSTOMERS_ADMIN, CUSTOMERS_READ)
                        .append(CUSTOMERS_ADMIN, CUSTOMERS_DELETE)
                        .append(CUSTOMERS_ADMIN, CUSTOMERS_PAGE_VIEW)

                        .append(SUPER_ADMIN, EMPLOYEES_ADMIN)
                        .append(EMPLOYEES_ADMIN, EMPLOYEES_CREATE)
                        .append(EMPLOYEES_ADMIN, EMPLOYEES_READ)
                        .append(EMPLOYEES_ADMIN, EMPLOYEES_DELETE)
                        .append(EMPLOYEES_ADMIN, EMPLOYEES_PAGE_VIEW)

                        .append(SUPER_ADMIN, DEPARTMENTS_ADMIN)
                        .append(DEPARTMENTS_ADMIN, DEPARTMENTS_CREATE)
                        .append(DEPARTMENTS_ADMIN, DEPARTMENTS_READ)
                        .append(DEPARTMENTS_ADMIN, DEPARTMENTS_DELETE)
                        .append(DEPARTMENTS_ADMIN, DEPARTMENTS_PAGE_VIEW)

                        // these lines added while studying ** pattern
                        .append(SUPER_ADMIN, ALL_VIEW)
                        .append(SUPER_ADMIN, ALL_CREATE)
                        .append(SUPER_ADMIN, ALL_DELETE)

                        .build()

        );
        return roleHierarchy;
    }
}
