package com.day4;

class A5{
    //생성자의 파라미터로 넘어온 원본 주소번지를
    //어떻게 하면 methodA 내부에서 사용할 수 있을까?
    A5Main a5Main = null;
    A5(A5Main a5Main){
        //변수 이름 앞에 this는 전변일 때만 가능함.
        this.a5Main = a5Main;//원본
        //생성자 안에서도 메소드 호출이 가능함.
        methodA();//호출
    }
    void methodA(){
        System.out.println(a5Main.ival);//a5Main이 전변이 되면 됨.
    }
}
public class A5Main {
    int ival = 3;
    public A5Main(){
        //아래 코드가 실행되어야 7번이 호출된다.
        A5 a5 = new A5(this);
    }
    //25-26(생성자호출)-19-21-7-9-11(methodA호출)
    //13-14(출력)
    public static void main(String[] args) {
        new A5Main();
    }
}
