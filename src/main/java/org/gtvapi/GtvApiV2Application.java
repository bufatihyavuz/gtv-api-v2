package org.gtvapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class GtvApiV2Application {

    public static void main(String[] args) {
        SpringApplication.run(GtvApiV2Application.class, args);
    }

}
