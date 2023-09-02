package com.niteshrajput.springbootwebfluxh2.repositories;

import com.niteshrajput.springbootwebfluxh2.models.Employee;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends ReactiveCrudRepository<Employee, Long> {
}
