package com.niteshrajput.springbootwebfluxh2.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Employee implements Serializable {

    @Id
    private Long id;
    private String name;
    private String email;
    private Double salary;



}
