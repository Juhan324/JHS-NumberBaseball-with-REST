package com.jhs.numberbaseball.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SocketRegist {
    private final String type = "socketregist";
    private String username;
    private Object socketId;
}
