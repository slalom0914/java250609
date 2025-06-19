package com.util;

class C{
    void methodA(){
        System.out.println("methodA");
    }
    //메서드 앞에 static 올 수 있다.
    //static있는 경우 인스턴스변수가 아니더라도
    //클래스타입(반드시 첫글자 대문자).methodB();
    static void methodB(){
        System.out.println("methodB");
    }
}

public class CMain {
    public static void main(String[] args) {
        //C.methodA();
        C.methodB();
    }
}
