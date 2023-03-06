package com.example.demospringsecuritymodel.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Data
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "{customer.name.validator.notblank.msg}")
    @Size(min = 2, max = 5, message = "{customer.name.validator.size.msg}")
    @Pattern(regexp = "[A-Za-z]*", message = "{customer.name.validator.patter.msg}")
    private String code;

    @Column(name = "first_name")
    @Pattern(regexp = "[A-Za-z-']*", message = "First name contains illegal characters")
    @NotBlank(message = "First name cannot be empty")
    private String firstName;

    @NotBlank(message = "Last name cannot be empty")
    @Pattern(regexp = "[A-Za-z-']*", message = "Last name contains illegal characters")
    @Column(name = "last_name")
    private String lastName;

    @NotBlank(message = "Address cannot be empty")
    @Pattern(regexp = "[\\w .\\-/,]*", message = "Address contains illegal characters")
    private String address;

    public Customer() {
    }
}
