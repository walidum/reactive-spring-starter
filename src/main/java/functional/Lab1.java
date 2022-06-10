package functional;

import java.util.concurrent.Callable;
import java.util.function.Function;

public class Lab1 {
    public static void main(String[] args) throws Exception {
        System.out.println("Résultat de la premiere function");
        System.out.println(getThreadCode.call());
        System.out.println("Résultat de la deuxieme function");
        System.out.println(calculateLenght.apply("java is awesome"));
    }

   static Callable<String> getThreadCode = () -> {
        int randomNumber = (int) (Math.random() * ((1024 - 1) + 1));
        return new StringBuilder().append("t").append(Thread.currentThread().getId()).append("-").append(randomNumber).toString();
    };

    static Function<String, Integer> calculateLenght = (String str) -> {
        if (str == null) return -1;
        return str.length();
    };
}
