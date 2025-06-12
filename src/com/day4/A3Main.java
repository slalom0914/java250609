package com.day4;
class A3{
    A3(){
        System.out.println("A3디폴트 생성자 호출");
    }
}
public class A3Main {
    public static void main(String[] args) {
        //인스턴스화 할 때 선언과 생성을 분리할 수도 있다.
        A3 a = null;//생성자가 호출되지 않는다.
        a = new A3();//이 때 생성자 호출이 된다.
    }
}
