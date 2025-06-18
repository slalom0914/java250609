package com.week1;

public class WhileTest1 {
    public static void main(String[] args) {
        int i = 4;
        //반복문은 무한루프 방지 코드를 작성하기
        while(i>3){//조건을 먼저 따지므로 실행기회를 한 번도 갖지 못할 수 있다.
            System.out.println("여기");
            i = i - 1;
        }
        System.out.println("111");
        do{//조건문이 뒤에 있어서 무조건 한 번은 실행이 된다.
            System.out.println("요기");
        }while (i>3);
    }
}

/*
제어문

조건문 : if문, switch문, 삼항연산자

반복문 : for, 개선된 for문, while, do..while

조건식 공통으로 필요하다. -> 비교연산자 -> true/false

조건식에 작성할 코드 - 어렵다.- 업무 이해

문법오류 :

논리오류 : 어렵다.

분기문 -> 흐름을 바꾼다.

 */