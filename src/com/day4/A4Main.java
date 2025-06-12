package com.day4;
class A4{
    //A4클래스 안에서 A4Main클래스가 선언한 전변을 사용하고 싶다.
    //어떡하지?
    //A4Main a4Main = new A4Main();

    A4(A4Main a4Main){
        a4Main.ival = 10;
        System.out.println(a4Main.ival);//0
    }
}
public class A4Main {
    int ival;
    public A4Main(){
       //생성자 호출이 안되어서 아래 코드는 실행기회가 없다.
        A4 a4 = new A4(this);
    }
    //static이 있는 메서드 내부에서는 this사용이 불가함.
    public static void main(String[] args) {
        A4Main a4Main = new A4Main();
        System.out.println("a4Main.ival : "+a4Main.ival);
    }
}
