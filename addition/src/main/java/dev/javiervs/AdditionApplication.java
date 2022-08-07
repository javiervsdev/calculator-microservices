package dev.javiervs;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(info = @Info(
        title = "Addition API",
        version = "1.0",
        description = "Arithmetic operation addition"))
@SpringBootApplication
public class AdditionApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdditionApplication.class, args);
    }
}
