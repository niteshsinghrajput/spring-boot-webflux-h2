package com.niteshrajput.springbootwebfluxh2.handlers;

import com.niteshrajput.springbootwebfluxh2.models.Employee;
import com.niteshrajput.springbootwebfluxh2.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyExtractor;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class EmployeeHandler {

    @Autowired
    private EmployeeRepository repository;

    public Mono<ServerResponse> getAllEmployees(ServerRequest request) {
        Flux<Employee> employees = repository.findAll();
        return ServerResponse.ok().body(employees, Employee.class);
    }

    public Mono<ServerResponse> getEmployeeById(ServerRequest request) {
        Long id = Long.parseLong(request.pathVariable("id"));
        Mono<Employee> existingEmployee = repository.findById(id);
        return ServerResponse.ok().body(existingEmployee, Employee.class);
    }

    public Mono<ServerResponse> createEmployee(ServerRequest request) {
        Mono<Employee> employeeMono = request.bodyToMono(Employee.class);

        return employeeMono
                .flatMap(employee -> repository.save(employee))
                .flatMap(savedEmployee -> ServerResponse
                        .created(request.uriBuilder().pathSegment("{id}").build(savedEmployee.getId()))
                        .body(BodyInserters.fromValue(savedEmployee)));
    }

    public Mono<ServerResponse> updateEmployee(ServerRequest request) {
        Long id = Long.parseLong(request.pathVariable("id"));
        Mono<Employee> updatedEmployeeMono = request.bodyToMono(Employee.class)
                .flatMap(employee -> repository.findById(id)
                        .flatMap(existingEmployee -> {
                            existingEmployee.setName(employee.getName());
                            existingEmployee.setEmail(employee.getEmail());
                            existingEmployee.setSalary(employee.getSalary());
                            return repository.save(existingEmployee);
                        })
                );
        return updatedEmployeeMono
                .flatMap(updatedEmployee ->
                        ServerResponse
                                .ok()
                                .body(BodyInserters.fromValue(updatedEmployee)));
    }

    public Mono<ServerResponse> deleteEmployee(ServerRequest request) {
        Long id = Long.parseLong(request.pathVariable("id"));
        return repository.findById(id)
                .flatMap(existingEmployee ->
                        repository.delete(existingEmployee)
                                .then(ServerResponse.noContent().build()))
                .switchIfEmpty(ServerResponse.notFound().build());
    }
}
