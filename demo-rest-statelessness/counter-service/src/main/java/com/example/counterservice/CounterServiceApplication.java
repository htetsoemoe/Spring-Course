package com.example.counterservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CounterServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CounterServiceApplication.class, args);
    }

}
// This is 'Stateless Request'
// curl -X POST -H 'Content-Type: application/json' -d '{"number":"5"}' http://localhost:8080/counter/stateless/countUp

// This is 'Stateful Request'
// curl -b cookies.txt -c cookies.txt -X POST http://localhost:8080/counter/stateful/countUp
