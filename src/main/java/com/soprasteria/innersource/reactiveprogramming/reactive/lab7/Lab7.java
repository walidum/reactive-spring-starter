package com.soprasteria.innersource.reactiveprogramming.reactive.lab7;

import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.Random;

public class Lab7 {


    public static Flux<String> numbers() {
        var random = new Random();
        Flux<Integer> fluxNumbers = Flux.create((fluxSink -> {
            for (int i = 1; i <= 5; i++) {
                fluxSink.next(random.nextInt());
            }
        }));
        return fluxNumbers.filter(integer -> integer % 2 == 0)
                .map(integer -> Integer.toHexString(integer.intValue()))
                .delayElements(Duration.ofMillis(50));

    }
}
