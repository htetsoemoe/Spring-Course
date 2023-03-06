package com.demo;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
//        Student student = new Student("lP", 25, "JDC");
//        System.out.println("Name " + student.getName());
//        System.out.println("Age " + student.getAge());
//        System.out.println("School " + student.getSchool());


//        BeanFactory beanFactory = new FileSystemXmlApplicationContext("beans.xml");
//        Student student = beanFactory.getBean("student", Student.class);
//
//        System.out.println(
//                String.format("Name : %s - Age : %d - School : %s", student.getName(), student.getAge(), student.getSchool())
//        );
//
//        ((FileSystemXmlApplicationContext)beanFactory).close();


//        ApplicationContext beanFactory = new FileSystemXmlApplicationContext("beans.xml");
//        Student student = beanFactory.getBean("student", Student.class);
//
//        System.out.println(
//                String.format("Name : %s - Age : %d - School : %s", student.getName(), student.getAge(), student.getSchool())
//        );
//
//        ((FileSystemXmlApplicationContext)beanFactory).close();



        // if we move bean.xml file to /src/main/java/resource directory

       /* ApplicationContext beanFactory = new ClassPathXmlApplicationContext("beans.xml");
        Student student = beanFactory.getBean("student", Student.class);

        // we need to create dependency object (Address) for Student object, which is call "control"
        //student.setAddress(new Address());

        student.setName("LP");
        student.setAge(25);
        student.setSchool("DRC");

        System.out.println(
                String.format("Name : %s, Age : %d, School : %s,", student.getName(), student.getAge(), student.getSchool())

        );
        student.studentInfo();

        ((ClassPathXmlApplicationContext)beanFactory).close();

        */


        // using AnnotationConfigApplicationContext(Path configfile)

        //ApplicationContext beanFactory = new AnnotationConfigApplicationContext(JavaConfig.class);

        AnnotationConfigApplicationContext beanFactory = new AnnotationConfigApplicationContext(JavaConfig.class);
        beanFactory.registerShutdownHook();

        Student student = beanFactory.getBean("student", Student.class);
        student.setName("LP");
        student.setAge(25);
        student.setSchool("DRC");

        System.out.println(
                String.format("Name : %s, Age : %d, School : %s,", student.getName(), student.getAge(), student.getSchool())

        );
        student.studentInfo();

        //((AnnotationConfigApplicationContext)beanFactory).close();
    }
}
