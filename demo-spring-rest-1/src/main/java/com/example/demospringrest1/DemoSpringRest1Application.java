package com.example.demospringrest1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoSpringRest1Application {

    // curl -X GET http://localhost:8080/customers
    // curl -X GET http://localhost:8080/customers/1

    // curl -X POST -v -H 'Content-Type: application/json' -d '{"code":"JD","firstName":"John","lastName":"Doe","address":"1714 North Bridge Road, PA 12356"}' http://localhost:8080/customers
    // curl -X PUT -v -H 'Content-Type: application/json' -d '{"code":"JD","firstName":"John","lastName":"Freeman","address":"1714 North Bridge Road, PA 12356"}' http://localhost:8080/customers/6

    // curl -X DELETE -vs http://localhost:8080/customers/3



    // curl -X POST -v -H 'Content-Type: application/json' -d '{'code':"JD","firstName":"John","lastName":"Doe","address":"1714 North Bridge Road, PA 12356"}' http://localhost:8080/customers
    public static void main(String[] args) {
        SpringApplication.run(DemoSpringRest1Application.class, args);
    }

}
