package com.soprasteria.innersource.reactiveprogramming.reactive.lab6;

import com.soprasteria.innersource.reactiveprogramming.functional.lab2.Employee;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

public class Lab6 {


    public static Flux<String> profile() {
        return Flux.just("Walid", "Boubechtoula", "28", "DEV");
    }

    public static Flux<Employee> employeeFlux() {
        List<Employee> employees = Arrays.asList(
                new Employee("Adem", 3000),
                new Employee("Riad", 5000),
                new Employee("Aya", 3500, "F"));
        return Flux.fromIterable(employees);
    }
}
