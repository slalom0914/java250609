package com.day11.design;
//상속을 받으면 부모가 정의한 전변을 사용할 수 있다.
//선언이 없어도 사용이 가능하다.
public class MallardDuck extends Duck {
    //오리라는 추상클래스의 실제 구현체 클래스 이다.
    //flyBehavior는 내안에 없는 변수 인데 어떻게 사용이 가능한가요?
    public MallardDuck() {
        flyBehavior = new FlyWithWings();
    }
    @Override
    public void display() {
        System.out.println("나는 청둥오리입니다.");
    }
}
