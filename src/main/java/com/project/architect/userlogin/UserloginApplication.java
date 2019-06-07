package com.project.architect.userlogin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.project.architect.userlogin.repository")
@EntityScan("com.project.architect.userlogin.entity")
@SpringBootApplication
public class UserloginApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(UserloginApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(UserloginApplication.class);
    }

}
