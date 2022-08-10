package com.jhs.numberbaseball.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NumberRegist {
    private final String type = "numberregist";
    private String username;
    private int number;
}
