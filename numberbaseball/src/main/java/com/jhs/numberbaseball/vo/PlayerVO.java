package com.jhs.numberbaseball.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.Nullable;

import java.util.Objects;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class PlayerVO {
    @NonNull private String username;
    @Nullable private int number;
    @Nullable private Object connection;

    @Override
    public boolean equals(Object o){
        if (this == o) {return true;}
        if(o==null)
            System.out.println("a");
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PlayerVO userVO = (PlayerVO) o;
        return Objects.equals(username,userVO.getUsername());
    }
}