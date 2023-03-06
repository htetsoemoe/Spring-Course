package com.example.demomanytomany.entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String grade;
    private String school;

    @ManyToMany(cascade = CascadeType.PERSIST, mappedBy = "students")   // Parent table
    private List<Subjects> subjects =
            new ArrayList<>();


    public void addSubject(Subjects subject) {
        subject.getStudents().add(this);//link bi direction
        subjects.add(subject);
    }

    public Student() {
    }

    public Student(String name, String grade, String school) {
        this.name = name;
        this.grade = grade;
        this.school = school;
    }
}
