package com.day1;

public class Variable1 {
    //선언부
    int i;//전역변수, member variable, global variable
    //사용자 정의 메소드 선언
    //리턴타입이나 파라미터를 바꿀 수도 있다.
    void methodA(){

    }
    //A.java -> A.class -> 실제 실행되는 파일이다.
    //배포할 때는 A.class배포한다.
    //javac A.java -> A.class
    //정해진 이름 - main메소드 선언
    public static void main(String[] args) {
        //변수 선언과 동시에 초기화도 하였다.
        //int i = 1;
        //변수 선언 앞에 타입이 있다.
        //정수를 선언할 있는 타입이 있다. - int(4byte), long(8byte)
        //자바는 컴파일을 하는 언어이므로 타입을 체크한다.
        //선언시에 타입을 적고 변수명을 적어야 한다.
        int i;//변수 선언
        i = 1;
        i = 2;
        //위치에 따라서 출력되는 값이 다릅니다.
        //변수에는 하나의 값만 기억됩니다.
        //정수를 담는 변수에는 동시에 여러개의 값을 담을 수 없다
        //한 번에 하나의 값만 담을 수 있다.
        System.out.println(i);//1이 출력된다.
        i = 3;
        //int보다 더 넓은 메모리 주소번지값을 가질 수 있다.
        //램을 더 크게 사용하고 싶다면 64비트 운영체제를 사용하세요.
        //램을 16GB사용하려면 64비트 운영체제를 설치해야 한다.
        long j = 1L;
    }
}
