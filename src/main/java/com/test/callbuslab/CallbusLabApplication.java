package com.test.callbuslab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class CallbusLabApplication {

    public static void main(String[] args) {
        SpringApplication.run(CallbusLabApplication.class, args);
    }

}
