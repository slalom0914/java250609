package com.week1;
//자바의 모든 부모 클래스는 Object이다.
//extends 하지 않더라도 Object무조건 상속된 상태이다.
public class Variable2 extends Object {
    //나는 여기에서 toString()구현한 적이 없다.
    //구현하지 않은 메서드를 어떻게 재정의 할 수 있지
    @Override
    public String toString() {
        return "나는 변수이다.";
    }
    public static void main(String[] args) {
        Variable2 v = new Variable2();
        System.out.println(v);
        System.out.println(v.toString());
        Object obj = "안녕";
        Object obj2 = new Object();
        //NullPointerException, NumberFormatException, CastingException
        String s = (String)obj2;
    }
}
