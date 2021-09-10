package com.naruhin.springbootexamplehillelhw5;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Car API", version = "1.0", description = "Cars Information"))
public class SpringBootExampleHillelHw5Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootExampleHillelHw5Application.class, args);
    }
}
