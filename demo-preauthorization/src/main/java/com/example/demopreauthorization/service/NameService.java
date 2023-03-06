package com.example.demopreauthorization.service;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class NameService {
    // preAuthorize and postAuthorize can be use SpEl Expression
    // 1
    @PreAuthorize("hasAnyAuthority('write')")
    public String getName() {
        return "WarMayMg";
    }

    // 2
    public Map<String, List<String>> secreteNames = Map.of(
            "john", List.of("Wild World", "Moon Pig"),
            "WarMayMg", List.of("Breeze", "Flash")
    );

    @PreAuthorize("#name == authentication.principal.username")
    public List<String> getSecreteNames(String name) {
        return secreteNames.get(name);
    }


}
