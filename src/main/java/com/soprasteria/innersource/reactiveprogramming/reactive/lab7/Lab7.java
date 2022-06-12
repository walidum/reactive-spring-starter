package com.soprasteria.innersource.reactiveprogramming.reactive.lab7;

import reactor.core.publisher.Flux;
import reactor.util.function.Tuples;

import java.time.Duration;

public class Lab7 {
    public static void main(String[] args) {
        System.out.println(Long.toHexString(20L));
    }

    public static Flux<String> numbers() {
        return Flux.interval(Duration.ofMillis(50))
                .startWith(200L)
                .filter(integer -> integer > 20 && (integer % 2 == 0))
                .map(aLong -> Long.toHexString(aLong.longValue()))
                .take(5)
                .log();


    }

    /**
     * from baeldung web site
     *
     * @return
     */
    private static Flux<Integer> generateFibonacciWithTuples() {
        return Flux.generate(
                () -> Tuples.of(0, 1),
                (state, sink) -> {
                    sink.next(state.getT1());
                    return Tuples.of(state.getT2(), state.getT1() + state.getT2());
                }
        );
    }
}
