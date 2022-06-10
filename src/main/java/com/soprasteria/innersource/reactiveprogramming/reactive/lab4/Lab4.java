package com.soprasteria.innersource.reactiveprogramming.reactive.lab4;

import com.soprasteria.innersource.reactiveprogramming.functional.lab2.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lab4 {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Adem", 3000),
                new Employee("Riad", 5000),
                new Employee("Iad", 1000),
                new Employee("Lara", 1400, "F"),
                new Employee("Aya", 3500, "F"));

        var list01 = employees.stream()
                .filter(employee -> employee.getSalary() < 1500)
                .collect(Collectors.toList());
        System.out.println("1** Employees with salary < 1500 ");
        list01.forEach(System.out::println);
        System.out.println();

        var names = employees.stream()
                .map(employee -> employee.getName())
                .collect(Collectors.joining(", "));

        System.out.println("2** Employees names : " + names);
        System.out.println();


        var groupByGenreResult = employees.stream()
                .collect(Collectors.groupingBy(Employee::getGenre));
        System.out.println();

        System.out.println("3** Employees with salary by gender  ");
        System.out.print("Genre M { ");
        groupByGenreResult.get("M").forEach(System.out::print);
        System.out.print(" }");

        System.out.println();
        System.out.print("Genre F { ");
        groupByGenreResult.get("F").forEach(System.out::print);
        System.out.print(" }");

        System.out.println();
        System.out.println();

        var salaryGenreF = groupByGenreResult.get("F")
                .stream().map(Employee::getSalary).reduce(0, (a, b) -> a + b);

        System.out.println("4** Salary of employees with gender F " + salaryGenreF);
        var salaryGenreM = groupByGenreResult.get("M")
                .stream().map(Employee::getSalary).reduce(0, (a, b) -> a + b);
        System.out.println("5** Salary of employees with gender M " + salaryGenreM);

    }
}
