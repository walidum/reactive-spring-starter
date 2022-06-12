package com.soprasteria.innersource.reactiveprogramming.reactive.lab8;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

class Lab8Test {
    @Test
    void shouldConcatN1N2() {
        var result1 = Lab8.concatN1N2();
        StepVerifier.create(result1)
                .expectNext("Elie")
                .expectNext("Jean")
                .expectNext("Lara")
                .expectNext("Anna")
                .expectNext("Laure")
                .expectNext("Bilel")
                .expectComplete()
                .verify();


        var result2 = Lab8.concatN2N1();

        StepVerifier.create(result2)
                .expectNext("Anna")
                .expectNext("Laure")
                .expectNext("Bilel")
                .expectNext("Elie")
                .expectNext("Jean")
                .expectNext("Lara")
                .expectComplete()
                .verify();

        var result3 = Lab8.mergeN1N2();
        StepVerifier.create(result3)
                .expectNext("Elie")
                .expectNext("Jean")
                .expectNext("Lara")
                .expectNext("Anna")
                .expectNext("Laure")
                .expectNext("Bilel")
                .expectComplete()
                .verify();


        var result4 = Lab8.mergeN2N1();


        StepVerifier.create(result4)
                .expectNext("Anna")
                .expectNext("Laure")
                .expectNext("Bilel")
                .expectNext("Elie")
                .expectNext("Jean")
                .expectNext("Lara")
                .expectComplete()
                .verify();

        System.out.println();
    }

}