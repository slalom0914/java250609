package com.day1.up;
// 하나의 소스파일(.java)에 두 개 클래스 선언이 가능하지만
// public 한 개에만 붙일 수 있다.
// A클래스에는 main메소드가 없어도 된다.
class A{
    int i;
}

public class AMain {
    public static void main(String[] args) {
        A a = new A();
        //다른 클래스의 변수를 전변이라 하더라도 접근이 불가함.
        //문제해결 - 인스턴스화
        System.out.println("초기화 이전 : "+a.i);//0
        System.out.println(a);
        a.i = 5;
        System.out.println("초기화 이전 : "+a.i);//5
        //컴파일 하는 자바에서는 선언시 반드시 타입을 적는다.
        //변수명 앞에 타입이 없다면 재정의 한 것이다.
        a = new A();
        System.out.println(a);
        a.i = 3;
        System.out.println("초기화 이후 : "+a.i);//5가 아니라  3이 출력됨
    }
}
