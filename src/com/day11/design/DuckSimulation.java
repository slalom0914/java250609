package com.day11.design;
//추상클래스와 인터페이스는 단독으로 인스턴스화 할 수 없다.
// 반드시 구현체 클래스가 있어서 추상메서드를 메서드 오버라이딩 해주었을 때
// 구현체 클래스 라고 하고 new 다음에는 구현체 클래스를 쓴다.
public class DuckSimulation {
    public static void main(String[] args) {
        //Duck himDuck = new Duck();
        //FlyBehavior fb = new FlyBehavior();
        Duck myDuck = new MallardDuck();
        myDuck.performFly();
        Duck herDuck = new RubberDuck();
        herDuck.performFly();
        Duck yourDuck = new WoodDuck();
        yourDuck.performFly();

    }
}
