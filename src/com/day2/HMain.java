package com.day2;

class H{
    String msg = "Haha";
}
public class HMain {
    public static void main(String[] args) {
        H h = new H();
        System.out.println(h.msg.replace('a','o'));
        h.msg = h.msg.replace('a','o');
        System.out.println(h.msg);//Haha, Hoho
    }
}
