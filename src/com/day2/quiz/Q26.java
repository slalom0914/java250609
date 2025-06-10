package com.day2.quiz;

public class Q26 {
    public static void main(String[] args) {
        int i = 1;
        int j = i++;//i를 j에 대입하고 난 뒤에 i를 1 증가시킴
        System.out.println(i+", "+j);// 2, 1
        // T T T
        // T F T
        // F T T
        // F F F
        if((i == ++j) || (i++ == j)){
            i = i + j;
        }else{
            System.out.println("실행기회가 없다.");
        }
        System.out.println(i);
    }
}
