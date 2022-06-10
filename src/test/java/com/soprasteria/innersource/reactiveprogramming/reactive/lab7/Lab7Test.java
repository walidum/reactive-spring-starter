package com.soprasteria.innersource.reactiveprogramming.reactive.lab7;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Lab7Test {

    @Test
    void shouldReturn5Element() {
        var elements = Lab7.numbers();
        int[] cpt = new int[1];
        cpt[0] = 0;
        elements
                .doOnNext(s -> ++cpt[0])
                .doOnComplete(() -> {
                    Assertions.assertTrue(cpt[0] == 5);
                });
    }

}