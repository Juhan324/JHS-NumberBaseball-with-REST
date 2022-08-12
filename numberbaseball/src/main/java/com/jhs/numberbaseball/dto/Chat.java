package com.jhs.numberbaseball.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Chat {
    private final String type = "chat";
    private String userName;
    private String target;
    private String chat;
}
