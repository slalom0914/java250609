package com.day5;

import java.util.Random;

public class RandomGameLogic {
    int dap;
    public void nanSu(){
        System.out.println("채번 메서드 호출");
        //정답채번하기- 초기화
        Random rand = new Random();
        dap =  rand.nextInt(10);
    }
}
