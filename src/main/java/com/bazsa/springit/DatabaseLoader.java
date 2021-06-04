package com.bazsa.springit;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class DatabaseLoader implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
       System.out.println("Database Loader ....");
    }
}
