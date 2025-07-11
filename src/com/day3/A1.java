//패키지 명 - 폴더
//no 패키지는 사용하지 않습니다. - 보안
package com.day3;

//클래스 선언하기
//접근제한자(public) class예약어 클래스이름
//낙타표기법 준수 - 첫글자는 대문자로 한다.
public class A1 {
    //선언부 - 변수, 메소드
    // 타입 변수명 - 선언위치, 초기화(위치)
    //정수부, 실수부 - 컴퓨터 정확히 1을 표현할 수 없다.
    //정확도 - float보다는 double정확도가 높다.
    double pi = 3.14d;//d는 생략함
    float pi2 = 2.14f;
    //재정의하는 문장은 선언부에 올 수 없다.
    //JVM 허락하지 않으면 쓸 수 없다.
    //생성자 - 나는 언제 호출되나요? - 인스턴스화
    //파라미터가 없는 생성자는 디폴트 생성자 이다.
    public A1(){
        //double타입을 강제로 float타입으로 바꿔줘
        pi2 = (float)pi;//캐스팅 연산자 -형전환연산자
        //1 = 3.14;
        System.out.println("pi2="+pi2);//3.14

    }
    //나는 파라미터가 있어서 디폴트 생성자가 아니다.
    public A1(double pi){
        this.pi = pi;
    }
    //메인메소드
    //순서가 섞여 있어도 자바스크립트 처럼 undefined 이슈는 없음.
    //defer, <script type=module> 모던 브라우저
    //모던 브라우저아니라서 -> babel
    //자바는 절차지향적인 언어가 아니라서 객체지향이라서 구조지향적이라서
    //섞여있어도 다 알고 있어.
    public static void main(String[] args) {
        //()붙은 경우에는 세가지가 있다.
        //1. 메소드, 2. 생성자(static대체제로 사용할 수 있다), 3. 캐스팅연산자
        //A1 a1 = new A1();
        A1 a1 = null;//클래스 선언이다
        //클래스를 생성한다.- 이때 디폴트 생성자가 호출된다.
        a1 = new A1();//이 때 파라미터가 없는 생성자가 호출된다.
    }
}
//여기에는 작성하지 않습니다.











