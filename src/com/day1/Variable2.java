package com.day1;

public class Variable2 {
    //변수의 선언 위치 - 전변
    int i;//초기화를 생략할 수 있다.
    //왜냐면 생성자가 대신 해준다.
    //지변은 반드시 초기화를 해야 합니다.
    //변수의 선언 위치가 메소드 내부 이면 - 지변
    //automatic variable(자동 자원소멸), local variable
    void methodA(){
        //원시형 타입의 변수는 호출하면 값이 나온다.
        int i;//정수를 담을 수 있는 지변 선언 및 초기화
        //i = 2;
        //지변을 초기화 하지 않으면 사용시 에러 발생함.
        //문제해결 능력
        //하나는 초기화를 한다.
        //전변을 사용한다. - 왜냐면 전변은 초기화를 생략할 수 있다. - 0
        //아래서 this를 사용하면 현재 클래스 이름이 Variable2이므로
        //this는 Variable2가리킨다.
        //this가 그때그때 다른 객체를 가리키기도 한다- 어렵다.
        System.out.println(this.i);//1
    }
    public static void main(String[] args) {
    //내 안에 있는 메소드 이더라도 main안에서(static 붙은 메소드안에)
    //호출하려면 인스턴스화를 해야 한다.
        //const board = new Board()
        //객체를 선언할 때도 타입을 적는다.
        Variable2 v2 = new Variable2();
        v2.methodA();
    }
}
