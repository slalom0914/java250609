package com.day1;

import java.util.Scanner;

public class Quiz1 {
    //1부터 5까지의 합을 구하는 프로그램을 작성하시오.
    //이 문제를 풀기 위해 변수 몇 개가 필요하나요?
    //선언한 변수의 초기화를 어떻게 해야 하나요?

    public static void main(String[] args) {
        //1부터 5까지의 합을 담을 변수 선언
        int hap=0;
        int j = 0;
        for(j=0;j<5;j++){
            int num = j+1;
            hap = hap + num;
        }
        System.out.println(hap);
    }
}
