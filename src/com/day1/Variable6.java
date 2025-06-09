package com.day1;

import java.util.Scanner;
//변수를 선언할 수 있다. - 타입이 온다 변수명을 쓴다 =  값을 준다.
//변수에 대한 초기화
//문제를 해결하기 위해 변수가 몇개 필요한가?
//필요한 변수의 타입을 말할 수 있다.
//사용자로 부터 입력값을 받아 올 수 있다.
public class Variable6 {
    public static void main(String[] args) {
        System.out.println("0부터 9사이의 숫자를 입력하세요.");
        //System은 현재 내가 사용하는 PC
        //in은 입력장치-마우스, 키보드, out출력장치-모니터,프린터
        //터미널을 통해서 사용자로 부터 입력받는 값을 담는다.
        Scanner sc = new Scanner(System.in);
        //메소드의 리턴타입이 있을 때만 가능하다.
        int i = sc.nextInt();
        System.out.println("사용자가 입력한 값은 "+i + " 입니다.");
        sc.close();
    }
}
