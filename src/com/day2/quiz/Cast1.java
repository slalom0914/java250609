package com.day2.quiz;

public class Cast1 {
    public static void main(String[] args) {
        //int(4byte) < long(8byte) < float(4byte) < double(8byte)
        int i = 1;
        double d = 2.1;//double실수형이다.
        i = (int)d;//casting operation- 형전환 연산자
        //d = i;//오른쪽에 더 작은 타입이 오는 것은 늘 합법임.
        //그러나 오른쪽에 더 큰 타입이 오는 것은 불가함.
        //강제로라도 넣고 싶다면 소수점은 빼고 담아줄께 - 캐스팅 연산자
        System.out.println(i);//2
        System.out.println(d);//2.1
    }
}
