package com.soprasteria.innersource.reactiveprogramming.reactive.lab9;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Todo {
    private Integer id;
    private Integer userId;
    private String title;
    private boolean completed;
}
