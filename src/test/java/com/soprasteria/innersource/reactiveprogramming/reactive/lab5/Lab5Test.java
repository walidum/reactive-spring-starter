package com.soprasteria.innersource.reactiveprogramming.reactive.lab5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Lab5Test {

    @Test
    void shouldReturnMyFirstName() {
        var monoFirstName = Lab5.publishFirstName("Walid");
        monoFirstName.subscribe(firstName -> {
            Assertions.assertTrue(firstName.equals("Walid"));
        });
    }

    @Test
    void shouldReturnNumberBetween100end1024() {
        var monoRandomNumber = Lab5.getRandomNumber();
        monoRandomNumber.subscribe(integer -> {
            Assertions.assertTrue(integer <= 1024 && integer >= 100);
        });

    }

}