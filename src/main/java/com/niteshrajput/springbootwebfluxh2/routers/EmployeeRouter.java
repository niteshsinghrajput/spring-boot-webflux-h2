package com.niteshrajput.springbootwebfluxh2.routers;

import com.niteshrajput.springbootwebfluxh2.handlers.EmployeeHandler;
import jdk.jfr.ContentType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class EmployeeRouter {

    @Bean
    public RouterFunction<ServerResponse> employeeRoutes(EmployeeHandler handler) {
        return route(GET("/api/employees"), handler::getAllEmployees)
                .andRoute(GET("/api/employees/{id}"), handler::getEmployeeById)
                .andRoute(POST("/api/employees").and(contentType(MediaType.APPLICATION_JSON)), handler::createEmployee)
                .andRoute(PUT("/api/employees/{id}").and(contentType(MediaType.APPLICATION_JSON)), handler::updateEmployee)
                .andRoute(DELETE("/api/employees/{id}"), handler::deleteEmployee);
    }

}
