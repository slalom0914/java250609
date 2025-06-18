package com.week1;
class Parent{
    Parent(){
        System.out.println("Parent생성자 호출");
    }
    void methodA(){
        System.out.println("Parent methodA");
    }
}
class Child extends Parent{
    Child(){
        System.out.println("Child생성자 호출");
    }
    @Override
    void methodA(){
        System.out.println("Child methodA");
    }
}
public class Method2 {
    public static void main(String[] args) {
    //서로 상속관계에 있다면 설사 자손의 객체를 생성하더라도
    //먼저 부모 생성자 호출이 된다.
    //부모 생성자 호출이 되면 메모리 상주 - 기준을 가지고 메소드오버라이딩
    //유무 파악 가능함.
        Parent p1 = new Parent();
        Child c1 = new Child();
        Parent p2 = new Child();//권장사항 - 다형성을 누릴 수 있다.
        p1.methodA();
        c1.methodA();
        p2.methodA();
    }
}
