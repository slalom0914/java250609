package com.network;

public class StaticMain {
    int ival;//non-static이다.
    //non-static은 static영역에서 사용이 불가함.
    static String name = "이순신";
    public static void main(String[] args) {
        StaticMain sm = new StaticMain();
        System.out.println(sm.ival);//0
        System.out.println(name);//이순신
    }
}
