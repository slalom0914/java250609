package com.emp;

public class A {
    public static void main(String[] args) {
        int no = 1;
        int x = no++;
        int y = no++;
        int z = no++;
        System.out.println(x);//1
        System.out.println(y);//2
        System.out.println(z);//3
    }
}
