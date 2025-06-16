package com.day11.design;
// 예약어가 class가 아니라 interface
public interface FlyBehavior {
    //추상메소드- 결합도를 낮추는 코드를 작성하기 위해서 이다.
    //상속이 재사용성의 모범 답안은 아닐 수  있다. - 결합도가 높다.
    //인터페이스는 일반 메소드를 가질 수 없다. 그래서 abstract생략한다.
    public void fly();//좌중괄호와 우중괄호가 없다.
}
