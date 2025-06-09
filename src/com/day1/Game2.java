package com.day1;

import java.util.Random;

public class Game2 {
    public static void main(String[] args) {
        Random rand = new Random();
        for(int j=0;j<10;j++){
            int num = rand.nextInt(10);
            System.out.println(num);
        }
    }
}
//채번하기가 먼저이다.
//아니다 숫자를 비교해서 힌트를 주는 것이 먼저이다.