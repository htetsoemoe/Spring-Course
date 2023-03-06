package com.example.demomanytomany.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Subjects {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String duration;

    // bi direction
    @ManyToMany
    private List<Student> students =
            new ArrayList<>();

    public Subjects() {
    }

    public Subjects(String name, String duration) {
        this.name = name;
        this.duration = duration;
    }
}
