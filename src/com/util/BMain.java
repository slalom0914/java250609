package com.util;
class B{
    public int ival;
    B(){
        System.out.println("B()생성자 호출");
    }
}
class B1{
    private int i;
    public static B1 b1;
    private B1(){
        System.out.println("B1()생성자 호출");
    }
    public int getI(){
        return i;
    }
    public static synchronized B1 getInstance(){
        if(b1 == null){
            b1 = new B1();
        }
        return b1;
    }
}
public class BMain {
    public static void main(String[] args) {
        B b = new B();
        System.out.println(b.ival);//0
        //디폴트 생성자 생략할 수 있다. 이유는 JVM대신 제공해 준다.
        B1 b1 = B1.getInstance();
        System.out.println(b1.getI());
    }
}
