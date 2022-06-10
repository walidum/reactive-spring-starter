package com.soprasteria.innersource.reactiveprogramming.reactive.lab3;

import com.soprasteria.innersource.reactiveprogramming.functional.lab2.Employee;

import java.util.Arrays;
import java.util.List;

public class Lab3 {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Adem", 3000),
                new Employee("Riad", 5000),
                new Employee("Iad", 2000),
                new Employee("Lara", 2500),
                new Employee("Aya", 3500));

        employees.stream().filter(employee -> employee.getSalary() > 2500).forEach(System.out::println);
        System.out.println();
        employees.stream()
                .filter(employee -> employee.getSalary() > 2500)
                .map(employee -> employee.getName() + " gagne beaucoup d'argent")
                .forEach(System.out::println);
    }
}
