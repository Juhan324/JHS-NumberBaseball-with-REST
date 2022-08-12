package com.jhs.numberbaseball.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Challenge {
    private final String type = "challenge";
    private String userName;
    private String target;
}
