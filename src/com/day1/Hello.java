package com.day1;
//어디에 코딩을 해야 하는거지?
//XXX.java파일에 코딩을 한다.
//클래스 선언을 반드시 해야 한다.
//하나의 어플리케이션이다. - 종료되면 스레드 회수, 자원회수
//그동안은 브라우저를 통해서 실행을 했다.
// liveserver: 5500
//로컬 PC에 JVM 설치가 되어 있으면 실행이 가능하다.
// java -version, javac -version
// 메소드도 함수처럼 이름 뒤에 괄호가 있다.
// 파라미터가 있다. -> String[] -
// 리턴타입은 반드시 void이다.
// main선언은 정해져 있다.
// public - 접근제한자 -> access modifier - > 유효 범위관련 - 중요 - 에러원인
// 클래스앞에 , 변수 앞에 , 메소드 앞에 올 수  있다. - 위치, 딱 맞는 초기화 위치
// 클래스 선언 내부에 변수와 메소드가  올 수 있다.
public class Hello {//클래스 이름은 대문자로 시작함
    //main메소드가 있어야 실행이 가능하다. - exe파일이 생성가능함.
    //로컬 프로그램이다. - 원격에서 사용(객체자원)이 불가함.
    //main메소드가 entry point이다.
    //그러나 모든 클래스가 다 main을 가질 필요는 없다.
    //자바 프로젝트에서 main메소드를 갖는 클래스는 하나면 된다.
    //클래스와 클래스사이에 의존관계를 갖는 클래스는 인스턴스화를
    //통해서 연계(연동) 가능하다.
    //EJS - include사용해 본 경험
    public static void main(String[] args) {
        System.out.println("Hello World");
    }
}
