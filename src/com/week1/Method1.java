package com.week1;

public class Method1 {
    void go(){
        System.out.println("go()");
    }
    void go(int i){
        System.out.println("go(int i)");
    }
    //public void go(int i){}
    void go(boolean isOk){
        System.out.println("go(boolean isOk)");
    }
    public static void main(String[] args) {
        Method1 m1 = new Method1();
        m1.go();
        m1.go(10);
        m1.go(true);
    }
}
/*
자바는 같은 이름의 메서드를 선언할 수 있다.
1. 메서드 오버로딩
:메서드 파라미터 타입이 다르거나 파라미터 갯수가 다르면 메서드 오버로딩이다.
:파라미터의 변수명이 다른 것은 영향이 없다.
:접근제한자가 있고 없고는 영향이 없다.
2. 메서드 오버라이딩
 */