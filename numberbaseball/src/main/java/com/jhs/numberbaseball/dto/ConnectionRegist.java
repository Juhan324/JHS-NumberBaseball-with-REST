package com.jhs.numberbaseball.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ConnectionRegist {
    private final String type = "connectionregist";
    private String username;
    private Object connection;
}
