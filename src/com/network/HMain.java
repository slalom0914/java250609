package com.network;
class H{
    int ival;
    private static H singleton = new H();
    //생성자에 private을 붙이면 new 사용하여 인스턴스화를 못함.
    private H(){
    }
    //정적메서드
    static H getInstance(){
        return singleton;
    }
}
public class HMain {
    public static void main(String[] args) {
        H h1 = H.getInstance();
        h1.ival = 1;
        H h2 = H.getInstance();
        h2.ival = 3;
        System.out.println(h1.ival);//3
        System.out.println(h2.ival);//3
        System.out.println(h1 == h2);//true
    }
}
