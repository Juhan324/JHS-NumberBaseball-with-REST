package com.jhs.numberbaseball.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.Nullable;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Result {
    private final String type="result";
    @NonNull private String userName;
    @NonNull private int inputNumber;
    @NonNull private int strike;
    @NonNull private int ball;
    @Nullable private String target;
}
