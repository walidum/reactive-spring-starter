package com.soprasteria.innersource.reactiveprogramming.functional.lab2;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Employee {

    private String name;
    private Integer salary;

    public Employee(String name, Integer salary) {
        this.name = name;
        this.salary = salary;
    }

    static IEmployeeFactory factory = (String name, Integer salary) -> new Employee(name, salary);

    static SalaryIncrease salaryIncrease = (Employee employee, Integer amount) -> {
        employee.setSalary(employee.salary + amount);
        return employee.salary;
    };

   
}
