package com.day11.design;

public class WoodDuck extends Duck {
    public WoodDuck() {
        //선언부의 타입과 생성부의 타입이 다를 수 있다.
        //이 때 가능한 것이 다형성이다.
        //같은 이름의 메서드를 호출하더라도 그 기능이 다른것.
        flyBehavior = new FlyNoWay();
    }
    @Override
    public void display() {
        System.out.println("나는 나무오리 입니다.");
    }
}
