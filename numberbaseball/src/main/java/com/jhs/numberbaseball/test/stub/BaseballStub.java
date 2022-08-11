package com.jhs.numberbaseball.test.stub;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BaseballStub {
    private static final List<Integer> answer = new ArrayList<>(Arrays.asList(1,2,3));
    public static List<Integer> compare(List<Integer> number){
        int strike=0;
        int ball=0;
        List<Integer> sb = new ArrayList<>();
        for(int i=0;i<number.size();i++){
            if(answer.contains(number.get(i))){
                if(answer.get(i)==number.get(i)){
                    strike++;
                }
                else{
                    ball++;
                }
            }
        }
        sb.add(strike);
        sb.add(ball);
        return sb;
    }

    public static List<Integer> intToList(int number){
        String tmp = String.valueOf(number);
        tmp = tmp.replaceAll(""," ").trim();
        String[] splitedNumber = tmp.split(" ");
        Integer[] numberArr = new Integer[splitedNumber.length];
        for(int i=0; i< splitedNumber.length;i++){
            numberArr[i]=Integer.parseInt(splitedNumber[i]);
        }
        List<Integer> result = Arrays.asList(numberArr);
        return result;
    }
}
