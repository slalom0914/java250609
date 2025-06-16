package com.day11;
// 참조형 : 배열타입, 열거타입, 클래스, 인터페이스
public class Array1 {
    public static void main(String[] args) {
        //1차배열- 원시형과 참조형
        int is[] = new int[3];//원소의 수가 3개이다.
        //초기화가 되지 않아서 디폴트 값을 갖는다.
        //배열의 첫번째 index는 0부터 이다.
        //is주소번지와 is[0] 주소번지가 같다.
        System.out.println(is[0]);//0
        System.out.println(is[1]);//0
        System.out.println(is[2]);//0
        try {
            //예외가 발생할 가능성이 있는 코드가 작성됨.
            System.out.println(is[3]);//ArrayIndexOutofBoundsException
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("배열의 범위를 벗어났습니다.");
        }
        //프로그램이 중간에 중지되는 것을 방지 하기 위해 예외처리한다.
        System.out.println("여기로 진행이 안됨.");// 후처리 필요함.
        for(int x=0;x<is.length;x++){

        }
        //2차배열
    }
}
