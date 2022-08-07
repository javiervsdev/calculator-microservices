package dev.javiervs;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(info = @Info(
        title = "Subtraction API",
        version = "1.0",
        description = "Arithmetic operation subtraction"))
@SpringBootApplication(scanBasePackages = {"dev.javiervs.subtraction", "dev.javiervs.common"})
public class SubtractionApplication {
    public static void main(String[] args) {
        SpringApplication.run(SubtractionApplication.class, args);
    }
}