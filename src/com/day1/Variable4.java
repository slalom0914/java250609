package com.day1;

public class Variable4 {
    //메소드 내부에서 선언된 변수는 밖에서 사용이 불가함.
    //전역적으로 사용할 수  없다.
    //메소드 선언시 static이 없는 경우를 non-static 메소드
    //static영역에서 non-static 사용하려면 어떡하지
    int a(){
        int x;
        x = 1;
        return x;
    }
    void b(int x){
        System.out.println(x);
    }
    public static void main(String[] args) {
        Variable4 v = new Variable4();
        //a의 결과를 다른 메소드에서 재사용해야 한다면
        //리턴타입의 변수를 선언해서 치환함.
        //한 번만 사용하면 끝이다.
        int x =v.a();
        v.b(10);//타입을 맞춰본다.
        //v.b(10.5);//타입을 맞춰본다.
        v.b(v.a());
        v.b(x);

    }
}
/*
원시형 변수 - 호출하면 값이 출력
char, byte, short, int, long, float, double, boolean

참조형 변수 - 클래스 - 주소번지 출력

원시형이나 참조형 모두 전변 or 지변
 */