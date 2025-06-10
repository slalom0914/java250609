package com.day2;
//StringBuilder, StringBuffer
//String은 원본이 바뀌지 않습니다. - 큰 장애
class G{
    String s1 = new String("hello");
    String s2 = new String("hello");
    String s3 = "hello";
    String s4 = "hello";
}
public class GMain {
    public static void main(String[] args) {
        G g = new G();
        System.out.println(g.s3==g.s4);//true
        System.out.println(g.s1==g.s2);//false
        System.out.println(g.s3);//hello출력됨
        System.out.println(g.s4);//hello출력됨
    }
}
/*
String은 클래스 중 유일하게 원시형 타입처럼 선언하고 호출이 가능함.
new를 사용하지 않고 같은 문자열을 선언하면 먼저 만들어진 문자열 원본을 참조함.

 */
