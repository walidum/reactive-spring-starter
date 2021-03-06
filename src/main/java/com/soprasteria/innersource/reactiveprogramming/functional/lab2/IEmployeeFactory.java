package com.soprasteria.innersource.reactiveprogramming.functional.lab2;

@FunctionalInterface
public interface IEmployeeFactory {
    Employee create(String name, Integer salary);
}
