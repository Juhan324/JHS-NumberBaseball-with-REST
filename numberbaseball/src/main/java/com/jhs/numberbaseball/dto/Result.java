package com.jhs.numberbaseball.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.Nullable;

@Data
@RequiredArgsConstructor
public class Result {
    private final String type="result";
    @NonNull private String userName;
    @NonNull private int inputNumber;
    @NonNull private String result;
    @Nullable private String target;
}
