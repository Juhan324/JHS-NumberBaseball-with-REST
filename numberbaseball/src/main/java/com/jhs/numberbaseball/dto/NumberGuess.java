package com.jhs.numberbaseball.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NumberGuess {
    private final String type = "numberguess";
    private String userName;
    private String target;
    private int number;
}
