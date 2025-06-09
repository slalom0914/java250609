package com.day1;

import java.util.Scanner;

public class Game1 {
    public static void main(String[] args) {
        int i = 55;
        System.out.println("당신의 점수를 입력하세요.\n");
        Scanner sc = new Scanner(System.in);
        i = sc.nextInt();
        if(i>=90){
            System.out.println(i);
        }else if(i>=80){
            System.out.println(i);
        }else if(i>=70){
            System.out.println(i);
        }else if(i>=60){
            System.out.println(i);
        }else{
            System.out.println("F학점");
        }
    }//end of main
}//////end of Game1
