package com.bazsa.springit;

import com.bazsa.springit.config.SpringitProperties;
import com.bazsa.springit.domain.Comment;
import com.bazsa.springit.domain.Link;
import com.bazsa.springit.repository.CommentRepository;
import com.bazsa.springit.repository.LinkRepository;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
@EnableJpaAuditing
@EnableConfigurationProperties(SpringitProperties.class)
public class SpringitApplication {

    @Autowired
    private SpringitProperties springitProperties;

    private static final Logger log = LoggerFactory.getLogger(SpringitApplication.class);

    public static void main(String[] args) {

        SpringApplication.run(SpringitApplication.class, args);

    }

   //

    CommandLineRunner runner(LinkRepository linkRepository, CommentRepository commentRepository){
        return args -> {
            Link link = new Link("Getting Started with Spring Boot 2","https://therealdanvega.com/spring-boot-2");
            linkRepository.save( link );

            Comment comment = new Comment("This Spring Boot 2 Link is awesome",link);
            commentRepository.save(comment);
            link.addComment(comment);

        };
    }

}
