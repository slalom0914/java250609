package com.day1;

public class Test {
    void methodA(int i){
        int j = i + 1;
        System.out.println(j);
    }
    public static void main(String[] args) {
        int i = 1;
        Test t = new Test();
        t.methodA(i);
    }
}
