package com.example.demomanytomany.service;

import com.example.demomanytomany.entities.Student;
import com.example.demomanytomany.entities.Subjects;
import com.example.demomanytomany.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Transactional
    public void createDb() {
        Student s1 = new Student("LP", "11", "DRC");
        Student s2 = new Student("Ko Moe", "11", "DRC");
        Student s3 = new Student("James Doe", "10", "DRC");

        Subjects subjects1 = new Subjects("CS-50", "3 months");
        Subjects subjects2 = new Subjects("AI", "6 months");
        Subjects subjects3 = new Subjects("Python", "3 months");


        //mapping
        s1.addSubject(subjects1);
        s1.addSubject(subjects2);
        s1.addSubject(subjects3);

        s2.addSubject(subjects1);

        s3.addSubject(subjects1);
        s3.addSubject(subjects3);

        studentRepository.save(s1);
        studentRepository.save(s2);
        studentRepository.save(s3);
    }
}
