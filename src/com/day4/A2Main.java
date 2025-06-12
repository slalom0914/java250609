package com.day4;
class A2{
    //같은 이름의 생성자를 여러개 가질 수 있다.
    //단 반드시 파라미터 타입이 다르거나 갯수가 달라야 한다.
    //그렇지 않으면 중복 선언으로 에러 발생함.
    A2(){
        System.out.println("A2 디폴트 생성자 호출");
    }
    A2(int a){//값에 의한 호출이다. call by value
        System.out.println("파라미터가 있는 생성자 호출: "+a);
    }
}
public class A2Main {
    public static void main(String[] args) {
        //인스턴스화를 할 때 new 클래스이름()하면 이것이 생성자를 호출해줌.
        A2 a = new A2(7);
    }
}
