package functional;

import java.util.concurrent.Callable;

public class Lab1 {
    public static void main(String[] args) throws Exception {
        Callable<String> getThreadCode = () -> {
            int randomNumber = (int) (Math.random() * ((1024 - 1) + 1));
            return new StringBuilder().append("t").append(Thread.currentThread().getId()).append("-").append(randomNumber).toString();
        };

        System.out.println(getThreadCode.call());
    }

}
