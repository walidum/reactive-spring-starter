package com.soprasteria.innersource.reactiveprogramming.reactive.lab7;

import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lab7 {

    public static Flux<String> numbers() {
        return Flux.range(200, 2000)
                .interval(Duration.ofMillis(50))
                .filter(integer -> integer % 2 == 0)
                .map(aLong -> Long.toHexString(aLong.longValue()))
                .take(5);
    }
}
