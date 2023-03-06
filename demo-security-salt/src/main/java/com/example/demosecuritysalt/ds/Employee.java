package com.example.demosecuritysalt.ds;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "First name cannot be empty")
    @Pattern(regexp = "[A-Za-z-]*", message = "First name contains illegal characters")
    @Column(name = "first_name")
    private String firstName;

    @NotBlank(message = "Last name cannot be empty")
    @Pattern(regexp = "[A-Za-z-]*", message = "Last name contains illegal characters")
    @Column(name = "last_name")
    private String lastName;

    @NotBlank(message = "Phone number cannot be empty")
    @Pattern(regexp = "[0-9\\-+]*", message = "Phone number contains illegal characters")
    @Column(name = "phone_number")
    private String phoneNumber;

    @NotBlank(message = "Address cannot be empty")
    @Pattern(regexp = "[\\w .\\-/,]*", message = "Address contains illegal characters")
    private String address;

    @NotBlank(message = "Cubicle Number cannot be empty")
    @Pattern(regexp = "[A-za-z0-9\\-]*", message = "Cubicle No. contains illegal characters")
    @Column(name = "cubicle_no")
    private String cubicleNo;

    public Employee() {
    }
}
