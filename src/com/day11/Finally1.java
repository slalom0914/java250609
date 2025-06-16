package com.day11;

public class Finally1 {
    public static void main(String[] args) {
        try{
            System.out.println(5/2);
            //가상머신과의 연결고리 끊김
            System.exit(0);
        }catch(ArithmeticException ae){
            System.out.println(("여기"));
        }finally{
            System.out.println("finally 무조건이 실행된다.");
        }
    }
}
