package com.day11.design;
//QuackBehavior qb = new MuteQuack();
//API활용 능력
public class MuteQuack implements QuackBehavior {
    //동일한 메서드 이지만 구현체 클래스에 따라서 기능이 달라진다.
    //다형성
    @Override
    public void quack() {
        System.out.println("무음");
    }
}
