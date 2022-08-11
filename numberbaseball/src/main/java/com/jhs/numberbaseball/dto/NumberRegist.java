package com.jhs.numberbaseball.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NumberRegist {
    private final String type = "numberregist";
    private String username;
    private int number;
}
