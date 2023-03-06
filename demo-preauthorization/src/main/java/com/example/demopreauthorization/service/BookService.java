package com.example.demopreauthorization.service;

import com.example.demopreauthorization.model.Employee;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BookService {

// preAuthorize and postAuthorize can be use SpEl Expression
    public Map<String, Employee> records =
            Map.of("warwar",
                    new Employee("War War",
                            List.of("The Mountain is Young", "The Remains of the Day"),
                            List.of("reader")),
                    "john",
                    new Employee("John William",
                            List.of("A Tale of Two Cities", "A Pale View of Hill"),
                            List.of("researcher"))
            );

    // if role is reader, this method will work
    @PostAuthorize("returnObject.roles.contains('reader')")
    public Employee getBookDetails(String name) {
        return records.get(name);
    }
}
