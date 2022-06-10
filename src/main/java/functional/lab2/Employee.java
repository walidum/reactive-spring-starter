package functional.lab2;

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

    public static void main(String[] args) {
        var adem = factory.create("Adem", 3000);
        System.out.println(adem);
        var newSalary = salaryIncrease.increase(adem, 1200);
        System.out.println(adem);
        System.out.println("New salary of adem " + newSalary);
    }

}
