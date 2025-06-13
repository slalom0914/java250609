package com.day5;
// 전역변수만 인스턴스변수.변수명 사용이 가능하다.
// 지역변수는 불가능하다.
// 전역변수는 초기화를 생략할 수 있다.
// 지역변수는 초기화를 반드시 해야 한다.
class B1{
    int ival;//전역변수
    int methodA(){
        int ival=1;//지역변수
        // this가 붙은건 전변, this가 없는 건 지변
        this.ival = ival;//0-> 1로 변경되었음.
        return ival;//1
        //return this.ival;
    }
}

public class B1Main {
    public static void main(String[] args) {
        //b1은 지역변수이다. 왜냐면 main 메소드 안에서 선언함.
        B1 b1=new B1();//클래스 타입 B1에 대해 인스턴스화 했음.
        //위 11번 전변에 대한 재정의가 아래 영향이 있다 | 없다.
        //영향이 없다. 왜냐면 methodA를 호출하지 않아서....
        //11번이 실행기회를 갖지 못함.
        int result = b1.methodA();//재정의가 일어남 - 원본이 변했다.- 사이드이펙트
        b1.ival=10;
        System.out.println(b1.ival);//0-> 1-> 10
        // 굳이 지변을 여기서 출력하고 싶다면 어떻게 하나요?
        System.out.println("result B1타입에 정의된 지변: "+result);//1
    }
}
