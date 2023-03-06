package com.example.demosecuritysalt.ds;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Code cannot be empty")
    @Size(min = 2, max = 5, message = "Code must have length of 2 to 5 characters")
    @Pattern(regexp = "[A-Za-z]*",message = "Code contains illegal characters")
    private String code;

    @NotBlank(message = "Name cannot be empty")
    @Pattern(regexp = "[A-Za-z ]*", message = "Name contains illegal characters")
    private String name;

    @NotBlank(message = "Country cannot be empty")
    @Pattern(regexp = "[A-Za-z ]*", message = "Country contains illegal characters")
    private String country;

    public Department() {
    }
}
