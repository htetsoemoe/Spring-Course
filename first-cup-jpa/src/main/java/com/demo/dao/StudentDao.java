package com.demo.dao;

import com.demo.entities.Student;
import jakarta.persistence.EntityManager;

import java.time.LocalDate;

public class StudentDao {

    private EntityManager em;

    public StudentDao(EntityManager em) {
        this.em = em;
    }

    public Student findStudentById(int id) {
        return em.find(Student.class, id);
    }

    public void createStudent(String name, LocalDate dob, String school) {
        em.getTransaction().begin();

        em.persist(new Student(name, dob, school));

        em.getTransaction().commit();

    }


    public void deleteStudent(int id) {
        em.getTransaction().begin();
        em.remove(findStudentById(id));
        em.getTransaction().commit();
    }


    public void updateStudent(String name, int id) {
        em.getTransaction().begin();

        Student existingStudent = findStudentById(id);
        existingStudent.setName(name);

        em.getTransaction().commit();
    }
}
