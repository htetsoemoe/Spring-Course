package com.example.demospringsecuritymodel.security.util;

public class RolesHierarchyBuilder {

    // StringBuilder is mutable, String isn't mutable
    private StringBuilder stringBuilder = new StringBuilder();

    public RolesHierarchyBuilder append(String upLineRole, String downLineRole) {
        stringBuilder.append(String.format("ROLE_%S > ROLE_%S\n", upLineRole, downLineRole));
        return this;
    }

    public String build() {
        return stringBuilder.toString();
    }

}
