package com.day2;
class J{
    int ival;
}
public class JMain {
    public static void main(String[] args) {
        J j = new J();
        j.ival = 1;
        System.out.println(j.ival);//1
        j = new J();
        j.ival = 2;
        System.out.println(j.ival);//2
        j = new J();
        j.ival = 3;
        System.out.println(j.ival);//3

    }
}
