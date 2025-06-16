package com.day11.design;

public class FlyNoWay implements FlyBehavior {
    //메소드 재정의 - 메소드 오버라이딩
    //부모로 인해 정해진 기능을 재정의하는 것.
    @Override
    public void fly() {
        System.out.println("날지 못합니다.");
    }
}
