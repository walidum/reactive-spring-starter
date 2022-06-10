package com.soprasteria.innersource.reactiveprogramming.functional.lab2;

public class Lab2 {
    public static void main(String[] args) {
        var adem = Employee.factory.create("Adem", 3000);
        System.out.println(adem);
        var newSalary = Employee.salaryIncrease.increase(adem, 1200);
        System.out.println(adem);
        System.out.println("New salary of adem " + newSalary);
    }
}
