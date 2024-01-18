package com.example.review.gamereviewservice.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
public class Game {

    @NotNull
    private Long id;

    @NotNull
    private String name;
}
