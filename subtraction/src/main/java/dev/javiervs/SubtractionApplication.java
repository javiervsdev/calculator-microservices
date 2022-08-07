package dev.javiervs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"dev.javiervs.subtraction", "dev.javiervs.common"})
public class SubtractionApplication {
    public static void main(String[] args) {
        SpringApplication.run(SubtractionApplication.class, args);
    }
}