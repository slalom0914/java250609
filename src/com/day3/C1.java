package com.day3;

public class C1 {
    public static void main(String[] args) {
        C1 c1 = new C1();
        System.out.println(c1);//B1@851
        c1 = null;
        System.out.println(c1);//null
        c1 = new C1();//B1@852
        System.out.println(c1);//B1@852
    }
}
