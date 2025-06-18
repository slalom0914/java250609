package com.day11.design;
//Duck 추상 클래스이다.- abstact붙임
public abstract class Duck {
    //인터페이스는 body가 없는 메소드만 가질 수 있다.- 결정할 수 없다.
    FlyBehavior flyBehavior;// 인터페이스 : 날다|날지 못한다.
    QuackBehavior quackBehavior;// 인터페이스 : 무음,  Squeak, Quack
    public Duck(){}
    public abstract void display();
    //절대로 부모나 인터페이스의 메소드를 직접 사용하지 않는다.
    //직접 메서드를 사용하는 것은 결합도 강하다.
    public void performFly(){
        flyBehavior.fly();//추상메서드: 나는 기능에 대해 결정할 수 없다.
    }
    public void performQuack(){
        quackBehavior.quack();//추상메서드: 나는 기능에 대해 결정할 수 없다.
    }
    public void swimming(){
        System.out.println("모든 오리는 물위에 뜬다.");
    }
}
/*
추상클래스, 인터페이스
직접 프레임워크를 만든다.
설계 - 계획 - 아직 어떻게 사용하지 결정할 수 없다.

클래스

객체를 생성하기
A a = new A();
Parent p = new Child();권장- 결합도 낮춰주고 독립적임
ActionListener al = new JFrameTest();
A a = b.getInstance() -> 메서드를 통해서 객체 생성함.
 */