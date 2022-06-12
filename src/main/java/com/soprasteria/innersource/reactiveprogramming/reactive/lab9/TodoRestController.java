package com.soprasteria.innersource.reactiveprogramming.reactive.lab9;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("todos")
public class TodoRestController {
    private static WebClient todosWebClient = WebClient.create("https://jsonplaceholder.typicode.com");

    @GetMapping
    public Flux<Todo> getTodos() {
        return todosWebClient.get()
                .uri("/todos")
                .retrieve()
                .bodyToFlux(Todo.class);
    }

    @GetMapping("/{id}")
    public Mono<Todo> getTodo(@PathVariable("id") final String id) {
        return todosWebClient.get()
                .uri("/todos/" + id)
                .retrieve()
                .bodyToMono(Todo.class);
    }

    @PostMapping
    public Mono<Todo> createToto(@RequestBody Todo todo) {
        return todosWebClient.post()
                .uri("/todos")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(Mono.just(todo), Todo.class)
                .retrieve()
                .bodyToMono(Todo.class);
    }
}
