package com.soprasteria.innersource.reactiveprogramming.reactive.lab6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Lab6Test {
    @Test
    void shouldReturnReturnTotalIs() {
        Lab6.profile().count().subscribe(aLong -> {
            Assertions.assertTrue(aLong == 4);
        });
    }

    @Test
    void shouldReturn3Employees() {
        Lab6.employeeFlux().next().subscribe(employee -> {
            Assertions.assertTrue(employee.getSalary() == 3000);
        });
        Lab6.employeeFlux().next().subscribe(employee -> {
            Assertions.assertTrue(employee != null);
        });
        Lab6.employeeFlux().next().subscribe(employee -> {
            Assertions.assertTrue(employee != null);
        });
    }
}