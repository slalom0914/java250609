package com.day3;
class D1{
    int ival;//0
    void methodA(D1 d1){
        System.out.println(d1.ival);
    }
}
public class D1Main {
    public static void main(String[] args) {
        D1 d1 = new D1();
        System.out.println(d1.ival);//0
        d1 = null;
        d1.methodA(d1);
        d1.methodA(null);
        System.out.println(d1.ival);//? 0 or NullPointerException
        d1 = new D1();
        d1.ival = 10;
        System.out.println(d1.ival);//10
    }
}
