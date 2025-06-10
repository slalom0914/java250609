package com.day2.quiz;
//모든 클래스의 부모 클래스가 Object이다.
public class Q24 {
    public static void main(String[] args) {
        String s = "abcde";
        Object ob = (Object)s;
        Object ob1 = "abcde";
        //Object ob2 = new Object("abcde");
        //System.out.println(s);
        //System.out.println(ob);
        System.out.println(s == ob);
        System.out.println(s == ob1);
        if("abcde".equals("abcde")){
            System.out.println("같다.");
        }
        if(s.equals(ob)){
            System.out.println("AAAA");
        }
        else{
            System.out.println("BBBB");
        }
    }
}
