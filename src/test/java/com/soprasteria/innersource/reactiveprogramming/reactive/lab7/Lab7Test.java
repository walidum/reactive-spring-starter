package com.soprasteria.innersource.reactiveprogramming.reactive.lab7;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;

class Lab7Test {

    @Test
    void shouldReturn5Element() {
        var count = Lab7.numbers().toStream().collect(Collectors.counting());
        Assertions.assertTrue(count == 5L);
    }

}