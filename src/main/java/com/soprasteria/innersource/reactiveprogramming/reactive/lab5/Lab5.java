package com.soprasteria.innersource.reactiveprogramming.reactive.lab5;

import reactor.core.publisher.Mono;

public class Lab5 {
    public static void main(String[] args) {
        var monoFirstName = publishFirstName("Walid");
        monoFirstName.subscribe(firstName -> System.out.println(firstName));

        var monoRandomNumber = getRandomNumber();
        monoRandomNumber.subscribe(integer -> System.out.println(integer));

    }

    static Mono<String> publishFirstName(String name) {
        return Mono.just(name);
    }

    static Mono<Integer> getRandomNumber() {
        return Mono.just((int) (Math.random() * ((1024 - 100) + 100)));
    }
}

