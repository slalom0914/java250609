package com.day2;
class C{
    int ival;
}
//제어권 - 객체 관리 - 라이프사이클 - 메모리
//로컬 객체관리 -> 원격객체 관리
public class CMain {
    C c=new C();
    public static void main(String[] args) {
        //CMain에서 ival변수를 호출하고 싶어
        //인스턴스화 할 때 마다 전변도 초기화 된다.- 0
        C c=new C();//지변
        c.ival=10;
        c.ival=20;
        System.out.println(c.ival);//0-> 10(상태)
        c = null;
        c=new C();//지변
        //원본이 바뀌면 사이드이펙트가 발생할 수 있다.- 어려움
        c.ival=100;//여기에는 영향이 없다
        System.out.println(c.ival);//0-> 100(상태)
    }
}
