package com.day2;

public class Type1 {
    public static void main(String[] args) {
        //실수형 타입
        float f1 = 3.14f;//4byte->32bit
        double d1 = 0.5;//8byte->64bit
        System.out.println(d1);//0.5
        //대입연산자를 이용한 재치환
        d1 = f1;//3.14
        System.out.println(d1);//3.14
    }
}
