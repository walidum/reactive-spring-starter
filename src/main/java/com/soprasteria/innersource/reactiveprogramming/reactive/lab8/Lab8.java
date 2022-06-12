package com.soprasteria.innersource.reactiveprogramming.reactive.lab8;

import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lab8 {

    private final static Flux name1 = Flux.just("Elie", "Jean", "Lara");
    private final static Flux name2 = Flux.just("Anna", "Laure", "Bilel");

    public static void main(String[] args) {
        // concat ca respect l'ordre  flux1 ensuite flux 2

        // merge first arrived enter to the result pipe, default order respect also


        Flux<Integer> evenNumbers = Flux
                .range(0, 20)
                .filter(x -> x % 2 == 0); // i.e. 2, 4

        Flux<Integer> oddNumbers = Flux
                .range(0, 20)
                .filter(x -> x % 2 > 0);  // ie. 1, 3, 5

        Flux.merge(evenNumbers.delayElements(Duration.ofMillis(1000)),
                oddNumbers.delayElements(Duration.ofMillis(500))).toStream().forEach(integer -> System.out.println(integer));
        //Flux.concat(evenNumbers, oddNumbers).toStream().forEach(integer -> System.out.println(integer));

    }

    public static Flux concatN1N2() {
        return name1.concatWith(name2);
    }

    public static Flux mergeN1N2() {
        return name1.mergeWith(name2);
    }

    public static Flux concatN2N1() {
        return name2.concatWith(name1);
    }

    public static Flux mergeN2N1() {
        return name2.mergeWith(name1);
    }
}
