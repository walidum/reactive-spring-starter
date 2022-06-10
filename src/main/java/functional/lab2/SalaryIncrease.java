package functional.lab2;

@FunctionalInterface
public interface SalaryIncrease {
    Integer increase(Employee employee, Integer amount);

}
