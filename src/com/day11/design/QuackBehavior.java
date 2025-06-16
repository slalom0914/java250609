package com.day11.design;
// 인터페이스는 반드시 구현체 클래스가 있어야 한다.
// 추상메소드 quack을 메소드 오버라이딩하는 클래스가 있어야 한다.
// QuackBehavior qb = new MuteQuack();
// QuackBehavior qb = new SqueakQuack();
// QuackBehavior qb = new Quack();
// 똑같이 quack()호출하더라도 어떤 때는 조용, 무음, 삐이익, 꽥꽥
// 동일한 메서드를 호출하는데 그 결과가 다르다.- 다형성
public interface QuackBehavior {
    public void quack();
}
