package com.bazsa.springit;

import com.bazsa.springit.config.SpringitProperties;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;



@SpringBootApplication
@EnableConfigurationProperties(SpringitProperties.class)
public class SpringitApplication {

    @Autowired
    private SpringitProperties springitProperties;

    private static final Logger log = LoggerFactory.getLogger(SpringitApplication.class);

    public static void main(String[] args) {

        SpringApplication.run(SpringitApplication.class, args);

    }

    @Bean
    @Profile("dev")
    CommandLineRunner runner(){
        return args -> {
          System.out.println("welcome message: " + springitProperties.getWelcomeMsg());
        };
    }

}
