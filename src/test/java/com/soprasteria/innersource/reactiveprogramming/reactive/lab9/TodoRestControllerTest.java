package com.soprasteria.innersource.reactiveprogramming.reactive.lab9;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import java.time.Duration;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
class TodoRestControllerTest {
    @Autowired
    private WebTestClient client;

    @BeforeEach
    public void setUp() {
        client = client.mutate()
                .responseTimeout(Duration.ofMillis(30000))
                .build();
    }

    @Test
    void shouldReturnFluxOfTodos() {
        client.get()
                .uri("http://localhost:8080/todos")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Todo.class);
    }

    @Test
    void shouldReturnMonoOfTodo() {
        client.get()
                .uri("http://localhost:8080/todos/104")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.id").isEqualTo("104");
    }

    @Test
    void shouldCreateTodo() {
        var todo = new Todo();
        todo.setTitle("title 1");
        todo.setUserId(6);
        todo.setCompleted(true);

        client.post()
                .uri("http://localhost:8080/todos")
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(todo), Todo.class)
                .exchange()
                .expectStatus().isOk();
    }
}