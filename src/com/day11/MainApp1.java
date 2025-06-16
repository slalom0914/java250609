package com.day11;
//어떤 경우를 상속관계로 맺어주나? A is a B
//소나타는 자동차 이다.
//자동차는 소나타 이다.
class Sup{
    int i;
    void methodA(){
        System.out.println("Sup methodA");
    }
}
class Sub extends Sup{
    Sub(){
        System.out.println(i);
    }
    @Override
    void methodA(){
        System.out.println("Sub methodA");
    }
    //메서드 오버로딩조건을 수렴한 경우이다.
    void methodA(int i){
        System.out.println("Sub methodA");
    }
/*
메서드 오버라이딩은 부모의 메서드를 훼손하면 안됨.
선언부는 일치한 상태에서 실행문만 다르다.
    int methodA(){
        System.out.println("Sub methodA");
        return 0;
    }
 */
}
//공통점 - 같은이름 메서드
//메서드 오버로딩
//메서드 오버라이딩
//추상클래스 상속 받거나 인터페이스를 implements를 했을때
public class MainApp1 {
    public static void main(String[] args) {
        //자손클래스에 동일한 메서드가 없으면 부모 메서드 호출됨
        //그러나 메서드 오버라이드 하면 그 때부터는 자손 메서드 호출됨
        //메서드 오버라이드는 메서드 선언부를 고쳐서는 안됨.
        Sub s = new Sub();
        s.methodA();
        Sup sup = new Sup();
        sup.methodA();
    }
}
