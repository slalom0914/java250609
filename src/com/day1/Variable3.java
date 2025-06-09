package com.day1;

public class Variable3 {
    //같은 이름의 변수를 사용할 수 있다.(단. 전변과 지변에 한해서)
    //정수 i를 초기화 하지 않으면 JVM은 디폴트 값으로 0을 준다.
    //우리는 코딩을 하고 일은 JVM이 한다.
    int i;//전변
    void methodA() {
        int i = 1;//지변
        //첫번째 방법은 메소드 내부에서 출력하는 것이다.
        System.out.println(i);//지역변수 i가 출력됨.
        //두번째 방업은 리턴타입을 이용하는 것이다.
    }//end of methodA
    int methodB() {
        int i =2;
        //리턴타입에 int로 함에 따라 methodB밖에서도 i 2를 사용할 수 있다.
        //지변 i를 함수 밖에서 사용하려면 리턴타입을 사용함.
        return i;
    }//end of methodA
    public static void main(String[] args) {
        //여기서 지변 i를 출력해 보세요. - 불가하다.
        //지변 i는 methodA영역 에서만 접근이 가능하다.
        //전변 i는 접근이 가능하다. - 인스턴스화를 통해서 접근이 가능함.
        //객체를 생성해야 객체에 선언된 변수나 메소드를 호출할 수 있다.
        //객체를 생성하는 방법이 인스턴스화 이다.
        Variable3 v3 = new Variable3();
        //클래스 타입 변수명 = new 클래스타입();
        //인스턴스화를 통해서 heap메모리 영역에 클래스 로딩해줌.
        //메모리에 상주하고 있으므로 우리는 변수나 메소드를 호출할 수 있다.
        //insert here - 전변 i를 출력해줘
        //static영역에서는 this수정자는 사용이 불가함.
        System.out.println(v3.i);//0출력됨
        //methodA의 리턴타입이 void이므로 대입연산자를 통해서
        //변수에 치환하는 것이 불가함.
        //int result = v3.methodA();
        //컴파일 하는 언어에서는 문법에러이면 실행은 불가함.
        //왜냐면 컴파일이 실패하면 XXX.class파일이 생성되지 못했다.
        int result2 = v3.methodB();
        System.out.println("result2 : "+result2);//2출력된다.
    }
}
