package com.day1.note;

class Param1{
    int ival;
}
//클래스 전역에서 사용할 수 있다. - 전변
//클래스와 클래스 관계 - (dependency injection) - 생성자다.
//클래스 구성요소는 변수와 메소드 그리고 생성자 이다.
//클래스 안에 코딩을 하면 외부에서 그 클래스를 재사용할 수 있다.
//재사용성과 이식성(사이드이펙트,버그)
//인스턴스화를 하면 해당 클래스가 선언한 변수와 메소드를
//내가 사용할 수 있다.
public class V2 {
    //파라미터로 객체의 주소번지를 넘길 수 있다.
    //메소드의 괄호안에도 변수를 선언하는 자리 임. - 지변
    void methodA(Param1 param1){
        System.out.println("methodA호출 성공");
        //전변은 초기화를 안해도 괜찮아 - int는 정수형- 0디폴트값
        System.out.println(param1.ival);//0출력
    }
    public static void main(String[] args) {
        Param1 p1 = new Param1();
        V2 v2 = new V2();
        p1.ival = 10;
        p1 = new Param1();//깊은 복사 - 복제본이다.
        v2.methodA(p1);//10이 아니라 새로운 객체 전달됨 여전히 0출력
    }
}
