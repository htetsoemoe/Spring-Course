package com.demo;

import com.demo.dao.StudentDao;
import com.demo.entities.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPU");
        EntityManager em = emf.createEntityManager();

//        EntityTransaction tx = em.getTransaction();
//
//        Student s1 = new Student("LP", LocalDate.of(2020, 3, 12), "DRC");
//        Student s2 = new Student("James Doe", LocalDate.of(2020, 2, 1), "DRC");
//        Student s3 = new Student("Ko Ko", LocalDate.of(2020, 1, 10), "DRC");
//
//
//        tx.begin();
//
//        em.persist(s1);
//        em.persist(s2);
//        em.persist(s3);
//
//        tx.commit();


        StudentDao obj = new StudentDao(em);
        obj.createStudent("James Bond", LocalDate.now(), "DRC");
        obj.createStudent("John William", LocalDate.now(), "ILBC");
        obj.createStudent("Cherry Phyu", LocalDate.now(), "ILBC");
        obj.createStudent("LP", LocalDate.now(), "DRC");

       // obj.updateStudent("Cherry", 3);

        System.out.println("Name : " + obj.findStudentById(3).getName());

        //obj.deleteStudent(1);
        em.close();
        emf.close();
    }
}
